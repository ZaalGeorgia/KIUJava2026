package columns;

import java.util.Random;


class Figure {

	static int x = Columns.WIDTH / 2 + 1, y = 1, c[] = new int[4];
	static Random r = new Random();

	Figure()
	{
		x = Columns.WIDTH / 2 + 1;
		y = 1;
		c[0] = 0;
		c[1] = Math.abs(r.nextInt())%7+1;
		c[2] = Math.abs(r.nextInt())%7+1;
		c[3] = Math.abs(r.nextInt())%7+1;
	}

	void moveRight() {
		x++;
	}

	void moveLeft() {
		x--;
	}

	void rotateUp(Columns columns) {
		columns.col = c[1];
		c[1] = c[2];
		c[2] = c[3];
		c[3] = columns.col;
	}

	void rotateDown(Columns columns) {
		columns.col = c[1];
		c[1] = c[3];
		c[3] = c[2];
		c[2] = columns.col;
	}

	void moveDown() {
		y++;
	}

	static Figure initFigure() {
		return new Figure();
	}
}