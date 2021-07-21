package array.strings;

public class RotateImage {

	/*
	 * Leetcode solution take transpose of the image first and then flip the matrix
	 * horizontally, that should give us our required rotated matrix -> flip the
	 * matrix horizontally using the two pointer approach Assumption -> this is a
	 * nxn matrix (square matrix)
	 */
	public static void rotateImage(int[][] matrix) {

		int n = matrix.length;
		int temp;

		if (n == 0 || n != matrix[0].length) {
			return;
		}

		// transpose of martrix
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// flip the matrix horizontally using two pointer approach
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				temp = matrix[i][j];
				// swap column 1st column with last column, second column with second last
				// column
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
	}
}
