package array.strings;

public class ZeroMatrix {

	public static void setZeroes(int[][] matrix) {

		if (matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		// nullify the row thats set
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				nullifyrowsAndColumns(matrix, i, 0, true);
			}
		}

		// nullify the column thats set
		for (int i = 0; i < column.length; i++) {
			if (column[i]) {
				nullifyrowsAndColumns(matrix, 0, i, false);
			}
		}
	}

	/*
	 * helper method to zero the rows and columns set the boolean flag if a row has
	 * to be zeroed set the flag to false if the column has to be zeroed
	 */
	private static void nullifyrowsAndColumns(int[][] matrix, int row, int column, boolean isRow) {

		if (isRow) {
			for (int i = 0; i < matrix[row].length; i++) {
				matrix[row][i] = 0;
			}
		} else {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][column] = 0;
			}
		}
	}
}
