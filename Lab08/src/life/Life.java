package life;

public class Life {
	private LifeBoard board;
	int[][] m;
	int grannar;

	/** Skapar ett Life-spel med spelplanen board. */
	Life(LifeBoard board) {
		this.board = board;
		m = new int[board.getRows()][board.getCols()];
	}

	/** Skapar en ny generation. */
	void newGeneration() {
		board.increaseGeneration();
		boolean[][] turn = new boolean[board.getRows()][board.getCols()];

		for (int i = 0; i < m.length; i++) {
			for (int k = 0; k < m[i].length; k++) {
				grannar = 0;
				int g = Grannar(i, k);
				if (board.get(i, k) == true && g > 3) {
					turn[i][k] = true;
				}
				if (board.get(i, k) == true && g < 2) {
					turn[i][k] = true;
				}
				if (board.get(i, k) == false && g == 3) {
					turn[i][k] = true;
				}

			}
		}

		// Byter värde på de rutor som har turn[i][k] == true genom att använda flip.
		for (int i = 0; i < turn.length; i++) {
			for (int k = 0; k < turn[i].length; k++) {
				if (turn[i][k] == true)
					flip(i, k);
			}
		}

	}

	// Räknar ut hur många grannar matris-värdet [row][col] har
	private int Grannar(int row, int col) {
		for (int rad = row - 1; rad < row + 2; rad++) {
			for (int kol = col - 1; kol < col + 2; kol++) {
				if (!(rad == row && kol == col) && board.get(rad, kol)) {
					grannar++;
				}
			}
		}
		return grannar;
	}

	// Ändrar innehållet i rutan med index row, col från individ till tom eller
	// tvärtom.
	void flip(int row, int col) {
		if (board.get(row, col) == true) // == true onödigt
			board.put(row, col, false);
		else
			board.put(row, col, true);

		// board.put(row, col, !board.get(row, col));
	}
}
