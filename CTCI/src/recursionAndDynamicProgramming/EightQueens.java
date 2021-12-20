/**
 * 
 */
package recursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * 8.13 Place eight queens in an 8x8 grid so that no queen is attacking each
 * other. ie none of them share the same row, column or diagonal
 * 
 * @author Hammad: 18-Dec-2021
 */
public class EightQueens {

	public void placeQueen(int row, Integer[] columns, ArrayList<Integer[]> results) {

		int GRID_SIZE = 2;
		if (row == GRID_SIZE) {
			results.add(columns.clone());
		} else {
			for (int column = 0; column < GRID_SIZE; column++) {
				if (checkValid(row, column, columns)) {
					columns[row] = column;
					placeQueen(row + 1, columns, results);
				}
			}
		}

	}

	private boolean checkValid(int row, int column, Integer[] columns) {

		for (int row2 = 0; row2 < row; row2++) {

			int column2 = columns[row2];
			// if there is a queen in the same column in a different row
			if (column == column2) {
				return false;
			}

			int columnDistance = Math.abs(column2 - column);
			int rowDistance = row - row2;

			if (rowDistance == columnDistance) {
				return false;
			}
		}

		return true;
	}

}
