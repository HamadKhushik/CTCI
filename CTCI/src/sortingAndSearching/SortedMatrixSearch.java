/**
 * 
 */
package sortingAndSearching;

/**
 * 10.9 Sorted Matrix Search, search an element in a two dimensional matrix
 * where both rows and columns are sorted in ascending order
 * 
 * @author Hammad: 03-Jan-2022
 */
public class SortedMatrixSearch {

	public static boolean naiveFind(int[][] matrix, int toFind) {

		if (matrix == null || matrix.length == 0) {
			return false;
		}

		int row = 0;
		int col = matrix[0].length - 1;

		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == toFind) {
				return true;
			} else if (matrix[row][col] > toFind) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}

}
