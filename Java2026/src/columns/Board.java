package columns;


public class Board {

	int newField[][];
	int oldField[][];
	int Level;

	void initBoard(Columns columns) {
		for (columns.col = 0; columns.col < Columns.WIDTH + 1; columns.col++) {
			for (columns.row = 0; columns.row < Columns.DEPTH + 1; columns.row++) {
				newField[columns.col][columns.row] = 0;
				oldField[columns.col][columns.row] = 0;
			}
		}
		Level = 0;
		columns.Score = 0;
		columns.row = 0;
		columns.figuresMatchedCounter = 0;
	}

}
