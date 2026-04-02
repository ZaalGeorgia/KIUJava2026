package columns;

import java.applet.*;
import java.awt.*;
import java.util.*;

public class Columns extends Applet implements Runnable {

	static final int BOX_SIZE = 25, DEPTH = 15, WIDTH = 7, MAX_LEVEL = 7, TIME_SHIFT = 250, NEXT_LEVEL_THRESHOLD = 33,
			MIN_TIME_SHIFT = 200, LEFT_BORDER = 2, TOP_BORDER = 2;

	private final Color COLORS[] = { Color.black, Color.cyan, Color.blue, Color.red, Color.green, Color.yellow,
			Color.pink, Color.magenta, Color.black };

	int col, row, figuresMatchedCounter, keyPressed;
	long Score, DScore, tc;
	Font fCourier;
	Figure figure;

	boolean noChanges = true, isKeyPressed = false;

	Graphics graphics;

	Thread thr = null;

	private Board board;

	void checkNeighbours(int a, int b, int c, int d, int i, int j) {
		if ((board.newField[j][i] == board.newField[a][b]) && (board.newField[j][i] == board.newField[c][d])) {
			board.oldField[a][b] = 0;
			DrawBox(a, b, 8);
			board.oldField[j][i] = 0;
			DrawBox(j, i, 8);
			board.oldField[c][d] = 0;
			DrawBox(c, d, 8);
			noChanges = false;
			Score += (board.Level + 1) * 10;
			figuresMatchedCounter++;
		}
		;
	}

	void Delay(long t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
		}
		;
	}

	void DrawBox(int x, int y, int c) {
		if (c == 0) {
			graphics.setColor(Color.black);
			graphics.fillRect(LEFT_BORDER + x * BOX_SIZE - BOX_SIZE, TOP_BORDER + y * BOX_SIZE - BOX_SIZE, BOX_SIZE,
					BOX_SIZE);
			graphics.drawRect(LEFT_BORDER + x * BOX_SIZE - BOX_SIZE, TOP_BORDER + y * BOX_SIZE - BOX_SIZE, BOX_SIZE,
					BOX_SIZE);
		} else if (c == 8) {
			graphics.setColor(Color.white);
			graphics.drawRect(LEFT_BORDER + x * BOX_SIZE - BOX_SIZE + 1, TOP_BORDER + y * BOX_SIZE - BOX_SIZE + 1,
					BOX_SIZE - 2, BOX_SIZE - 2);
			graphics.drawRect(LEFT_BORDER + x * BOX_SIZE - BOX_SIZE + 2, TOP_BORDER + y * BOX_SIZE - BOX_SIZE + 2,
					BOX_SIZE - 4, BOX_SIZE - 4);
			graphics.setColor(Color.black);
			graphics.fillRect(LEFT_BORDER + x * BOX_SIZE - BOX_SIZE + 3, TOP_BORDER + y * BOX_SIZE - BOX_SIZE + 3,
					BOX_SIZE - 6, BOX_SIZE - 6);
		} else {
			graphics.setColor(COLORS[c]);
			graphics.fillRect(LEFT_BORDER + x * BOX_SIZE - BOX_SIZE, TOP_BORDER + y * BOX_SIZE - BOX_SIZE, BOX_SIZE,
					BOX_SIZE);
			graphics.setColor(Color.black);
			graphics.drawRect(LEFT_BORDER + x * BOX_SIZE - BOX_SIZE, TOP_BORDER + y * BOX_SIZE - BOX_SIZE, BOX_SIZE,
					BOX_SIZE);
		}
		// g.setColor (Color.black);
	}

	void drawField(Graphics g) {
		for (int i = 1; i <= DEPTH; i++) {
			for (int j = 1; j <= WIDTH; j++) {
				DrawBox(j, i, board.newField[j][i]);
			}
		}
	}

	void DrawFigure(Figure f) {
		DrawBox(f.x, f.y, f.c[1]);
		DrawBox(f.x, f.y + 1, f.c[2]);
		DrawBox(f.x, f.y + 2, f.c[3]);
	}

	void DropFigure(Figure f) {
		int zz;
		if (f.y < DEPTH - 2) {
			zz = DEPTH;
			while (board.newField[f.x][zz] > 0) {
				zz--;
			}
			DScore = (((board.Level + 1) * (DEPTH * 2 - f.y - zz) * 2) % 5) * 5;
			f.y = zz - 2;
		}
	}

	boolean FullField() {
		int i;
		for (i = 1; i <= WIDTH; i++) {
			if (board.newField[i][3] > 0) {
				return true;
			}
		}
		return false;
	}

	void HideFigure(Figure f) {
		DrawBox(f.x, f.y, 0);
		DrawBox(f.x, f.y + 1, 0);
		DrawBox(f.x, f.y + 2, 0);
	}

	@Override
	public void init() {
		board = new Board();
		board.newField = new int[WIDTH + 2][DEPTH + 2];
		board.oldField = new int[WIDTH + 2][DEPTH + 2];
		graphics = getGraphics();
		setFocusable(true);
	}

	@Override
	public boolean keyDown(Event e, int k) {
		isKeyPressed = true;
		keyPressed = e.key;
		return true;
	}

	@Override
	public boolean lostFocus(Event e, Object w) {
		isKeyPressed = true;
		keyPressed = 'P';
		return true;
	}

	void PackField() {
		int i, j, n;
		for (i = 1; i <= WIDTH; i++) {
			n = DEPTH;
			for (j = DEPTH; j > 0; j--) {
				if (board.oldField[i][j] > 0) {
					board.newField[i][n] = board.oldField[i][j];
					n--;
				}
			}
			;
			for (j = n; j > 0; j--) {
				board.newField[i][j] = 0;
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		// ShowHelp(g);

		g.setColor(Color.black);

		ShowLevel(g);
		ShowScore(g);
		drawField(g);
		DrawFigure(figure);
		requestFocus();
	}

	void PasteFigure(Figure f) {
		board.newField[f.x][f.y] = f.c[1];
		board.newField[f.x][f.y + 1] = f.c[2];
		board.newField[f.x][f.y + 2] = f.c[3];
	}

	@Override
	public void run() {
		board.initBoard(this);
		graphics.setColor(Color.black);
		requestFocus();

		do {
			tc = System.currentTimeMillis();
			figure = Figure.initFigure();
			DrawFigure(figure);
			while ((figure.y < DEPTH - 2) && (board.newField[figure.x][figure.y + 3] == 0)) {
				checkTimeAndMoveDownIfNeeded();
				DScore = 0;
				processUserEventsIfAny();
			}
			PasteFigure(figure);
			do {
				noChanges = true;
				findMatches();
				if (!noChanges) {
					Delay(500);
					collapse();
				}
			} while (!noChanges);
		} while (!FullField());
	}

	private void processUserEventsIfAny() {
		do {
			Delay(50);
			if (isKeyPressed) {
				processEvent();
			}
		} while ((int) (System.currentTimeMillis() - tc) <= (MAX_LEVEL - board.Level) * TIME_SHIFT + MIN_TIME_SHIFT);
	}

	private void checkTimeAndMoveDownIfNeeded() {
		if ((int) (System.currentTimeMillis() - tc) > (MAX_LEVEL - board.Level) * TIME_SHIFT + MIN_TIME_SHIFT) {
			tc = System.currentTimeMillis();
			HideFigure(figure);
			figure.moveDown();
			DrawFigure(figure);
		}
	}

	private void collapse() {
		PackField();
		drawField(graphics);
		Score += DScore;
		ShowScore(graphics);
		changeLevelIfNeeded();
	}

	private void changeLevelIfNeeded() {
		if (figuresMatchedCounter >= NEXT_LEVEL_THRESHOLD) {
			figuresMatchedCounter = 0;
			if (board.Level < MAX_LEVEL) {
				board.Level = board.Level + 1;
			}
			ShowLevel(graphics);
		}
	}

	private void processEvent() {
		isKeyPressed = false;
		switch (keyPressed) {
		case Event.LEFT:
			if ((figure.x > 1) && (board.newField[figure.x - 1][figure.y + 2] == 0)) {
				HideFigure(figure);
				figure.moveLeft();
				DrawFigure(figure);
			}
			break;
		case Event.RIGHT:
			if ((figure.x < WIDTH) && (board.newField[figure.x + 1][figure.y + 2] == 0)) {
				HideFigure(figure);
				figure.moveRight();
				DrawFigure(figure);
			}
			break;
		case Event.UP:
			figure.rotateUp(this);
			DrawFigure(figure);
			break;
		case Event.DOWN:
			figure.rotateDown(this);
			DrawFigure(figure);
			break;
		case ' ':
			HideFigure(figure);
			DropFigure(figure);
			DrawFigure(figure);
			tc = 0;
			break;
		case 'P':
		case 'p':
			while (!isKeyPressed) {
				HideFigure(figure);
				Delay(500);
				DrawFigure(figure);
				Delay(500);
			}
			tc = System.currentTimeMillis();
			break;
		case '-':
			if (board.Level > 0) {
				board.Level = board.Level - 1;
			}
			figuresMatchedCounter = 0;
			ShowLevel(graphics);
			break;
		case '+':
			if (board.Level < MAX_LEVEL) {
				board.Level = board.Level + 1;
			}
			figuresMatchedCounter = 0;
			ShowLevel(graphics);
			break;
		}
	}

	void ShowHelp(Graphics g) {
		g.setColor(Color.black);

		g.drawString(" Keys available:", 200 - LEFT_BORDER, 102);
		g.drawString("Roll Box Up:     ", 200 - LEFT_BORDER, 118);
		g.drawString("Roll Box Down:   ", 200 - LEFT_BORDER, 128);
		g.drawString("Figure Left:     ", 200 - LEFT_BORDER, 138);
		g.drawString("Figure Right:    ", 200 - LEFT_BORDER, 148);
		g.drawString("Level High/Low: +/-", 200 - LEFT_BORDER, 158);
		g.drawString("Drop Figure:   space", 200 - LEFT_BORDER, 168);
		g.drawString("Pause:           P", 200 - LEFT_BORDER, 180);
		g.drawString("Quit:     Esc or Q", 200 - LEFT_BORDER, 190);
	}

	void ShowLevel(Graphics g) {
		g.setColor(Color.black);
		g.clearRect(LEFT_BORDER + 100, 390, 100, 20);
		g.drawString("Level: " + board.Level, LEFT_BORDER + 100, 400);
	}

	void ShowScore(Graphics g) {
		g.setColor(Color.black);
		g.clearRect(LEFT_BORDER, 390, 100, 20);
		g.drawString("Score: " + Score, LEFT_BORDER, 400);
	}

	@Override
	public void start() {
		graphics.setColor(Color.black);

		// setBackground (new Color(180,180,180));

		if (thr == null) {
			thr = new Thread(this);
			thr.start();
		}
		requestFocus();
	}

	@Override
	public void stop() {
		if (thr != null) {
			thr.stop();
			thr = null;
		}
	}

	void findMatches() {
		int i, j;
		for (i = 1; i <= DEPTH; i++) {
			for (j = 1; j <= WIDTH; j++) {
				board.oldField[j][i] = board.newField[j][i];
			}
		}
		for (i = 1; i <= DEPTH; i++) {
			for (j = 1; j <= WIDTH; j++) {
				if (board.newField[j][i] > 0) {
					checkNeighbours(j, i - 1, j, i + 1, i, j);
					checkNeighbours(j - 1, i, j + 1, i, i, j);
					checkNeighbours(j - 1, i - 1, j + 1, i + 1, i, j);
					checkNeighbours(j + 1, i - 1, j - 1, i + 1, i, j);
				}
			}
		}
	}
}