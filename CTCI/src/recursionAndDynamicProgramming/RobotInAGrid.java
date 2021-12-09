/**
 * 
 */
package recursionAndDynamicProgramming;

import java.awt.Point;
import java.util.ArrayList;

/**
 * 8.2, Robot in grid of rows and columns. Find the number of paths to bottom
 * right corner of the grid from the origin
 * 
 * @author Hammad: 09-Dec-2021
 */
public class RobotInAGrid {

	public ArrayList<Point> findPaths(int row, int column) {

		boolean[][] maze = new boolean[row][column];

		if (row == 0) {
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		if (findPaths(maze, row - 1, column - 1, path)) {
			return path;
		}
		return null;

	}

	private boolean findPaths(boolean[][] maze, int row, int column, ArrayList<Point> path) {

		if (row < 0 || column < 0 || !maze[row][column]) {
			return false;
		}

		boolean isAtOrigin = (row == 0) && (column == 0);

		if (isAtOrigin || findPaths(maze, row - 1, column, path) || findPaths(maze, row, column - 1, path)) {
			path.add(new Point(row, column));
			return true;
		}
		return false;
	}

}
