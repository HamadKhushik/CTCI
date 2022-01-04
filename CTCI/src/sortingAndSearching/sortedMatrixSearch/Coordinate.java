package sortingAndSearching.sortedMatrixSearch;

/**
 * Coordinate class to track the cells in a multi dimensional matrix
 * 
 * @author Hammad: 04-Jan-2022
 */
public class Coordinate implements Cloneable {

	int row;
	int col;

	public Coordinate(int r, int c) {
		row = r;
		col = c;
	}

	public boolean inbound(int[][] matrix) {
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
	}

	public boolean isBefore(Coordinate p) {
		return row <= p.row && col <= p.col;
	}

	public Coordinate clone() {
		return new Coordinate(row, col);
	}

	public void setToAverage(Coordinate min, Coordinate max) {
		row = (min.row + max.row) / 2;
		col = (min.col + max.col) / 2;
	}

	public String toString() {
		return row + ":" + col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
