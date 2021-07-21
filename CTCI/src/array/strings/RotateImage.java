package array.strings;

public class RotateImage {

	/*
	 * Leetcode solution take transpose of the image/matrix first and then flip the
	 * matrix horizontally(for clockwise rotation), that should give us our required
	 * rotated matrix -> flip the matrix horizontally using the two pointer approach
	 * Assumption -> this is a nxn matrix (square matrix)
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

	/*
	 * rotates an image/matrix clockwise layer by layer in place stack overflow link
	 * below for more information
	 * https://stackoverflow.com/questions/25882480/rotating-a-nxn-matrix-in-java
	 */
	public static void rotateImageLayerByLayer(int[][] matrix) {

		int n = matrix.length;
		int temp = 0;

		if (n == 0 || n != matrix[0].length) {
			return;
		}

		for (int layer = 0; layer < n / 1; layer++) {

			// last row/column in that particular layer
			int last = n - 1 - layer;
			for (int i = layer; i < last; i++) {

				// its used to find the particular element within the layer
				int offset = i - layer;

				// top
				temp = matrix[layer][i];

				// left -> top
				matrix[layer][i] = matrix[last - offset][layer];

				// bottom -> left
				matrix[last - offset][layer] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = temp;
			}
		}

	}
}
