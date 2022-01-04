package sortingAndSearching.sortedMatrixSearch;

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

	/**
	 * recursive approach to find a value in a multi dimensional matrix using binary
	 * search along the diagonal of the matrix
	 * 
	 * @return Coordinate where 'x' is found
	 */
	public static Coordinate find(int[][] matrix, int x) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}
		Coordinate origin = new Coordinate(0, 0);
		Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
		return find(matrix, origin, dest, x);
	}

	private static Coordinate find(int[][] matrix, Coordinate origin, Coordinate dest, int x) {

		if (!origin.inbound(matrix) || !dest.inbound(matrix)) {
			return null;
		}

		if (matrix[origin.row][origin.col] == x) {
			return origin;
		} else if (!origin.isBefore(dest)) {
			return null;
		}

		Coordinate start = origin.clone();
		int diagdist = Math.min(dest.row - origin.row, dest.col - origin.col);
		Coordinate end = new Coordinate(origin.row + diagdist, origin.col + diagdist);
		Coordinate pivot = new Coordinate(0, 0);

		while (start.isBefore(end)) {

			pivot.setToAverage(start, end);

			if (x > matrix[pivot.row][pivot.col]) {
				start.row = pivot.row + 1;
				start.col = pivot.col + 1;
			} else {
				end.row = pivot.row - 1;
				end.col = pivot.col - 1;
			}

		}
		return partitionAndSearch(matrix, origin, dest, start, x);
	}

	private static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot,
			int x) {

		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.col);
		Coordinate lowerLeftdest = new Coordinate(dest.row, pivot.col - 1);

		Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.col);
		Coordinate upperRightdest = new Coordinate(pivot.row - 1, dest.col);

		Coordinate lowerLeft = find(matrix, lowerLeftOrigin, lowerLeftdest, x);
		if (lowerLeft == null) {
			return find(matrix, upperRightOrigin, upperRightdest, x);
		}

		return lowerLeft;
	}

}
