package algorithm;

import java.util.Arrays;

public class EightQueens2 {

	public int[][] ground = new int[8][8];
	public int[] colOfEachRow = new int[8];
	private int counter = 0;

	public boolean locationAllowed(int row, int column) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 8; j++) {
				if (ground[i][j] == 0) {
					continue;
				}
				if (!columnAllowed(i, column)) {
					return false;
				}
				if (!slashAllowed(i, row, j, column)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean columnAllowed(int tempRow, int column) {
		if (ground[tempRow][column] == 1) {
			return false;
		}
		return true;
	}

	private boolean slashAllowed(int tempRow, int row, int tempColumn, int column) {
		if (tempRow - row == tempColumn - column || tempRow - row == column - tempColumn) {
			return false;
		}
		return true;
	}

	public void showResult() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (1 == ground[i][j]) {
					System.out.print("田  ");
				} else {
					System.out.print("口  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void findResult() {
		int row = 0;
		ground[0][0] = 1;
		while (colOfEachRow[0] < 8) {
			if (colOfEachRow[row] > 7) {
				System.out.println("here-----------------");
				row--;
				backTrack(row);
				continue;
			}
			for (int i = colOfEachRow[row]; i < 8; i++) {
				if (locationAllowed(row, i)) {
					putQueenAndRecoreTheLocation(row, i);
					row++;
					break;
				} else if (i == 7) {
					row--;
					backTrack(row);
					break;
				}
			}
			if (row == 8) {
				showResult();
				this.counter++;
				row--;
				backTrack(row);
			} else {

			}
		}
	}

	private void putQueenAndRecoreTheLocation(int row,int column) {
		ground[row][column] = 1;
		colOfEachRow[row] = column;
	}
	
	private void backTrack(int row) {
		colOfEachRow[row]++;
		cleanGround(row);
	}

	// clean the rows lower than current row,except current row
	private void cleanGround(int row) {
		for (int i = row + 1; i < 8; i++) {
			Arrays.fill(ground[row], 0);
			this.colOfEachRow[i] = 0;
		}
		// the loop cannot clean ground[7] ,so I clean it here out the loop
		Arrays.fill(ground[7], 0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EightQueens2 eq = new EightQueens2();
		eq.findResult();
		System.out.println(eq.counter);
	}

}
