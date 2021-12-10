/**
 * 
 */
package recursionAndDynamicProgramming;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * 8.2, Robot in grid of rows and columns. Find the number of paths to bottom
 * right corner of the grid from the origin
 * 
 * @author Hammad: 09-Dec-2021
 */
public class RobotInAGrid {

	public ArrayList<Point> findPaths(int row, int column) {

		boolean[][] maze = new boolean[row][column];
		initializeArray(maze);

		if (row == 0) {
			return null;
		}

		ArrayList<Point> path = new ArrayList<Point>();
		if (findPaths(maze, row - 1, column - 1, path)) {
			return path;
		}

		return null;
	}

	// created a 2D boolean array as the grid for the robot
	private void initializeArray(boolean[][] grid) {

		if (grid[0].length == 0) {
			return;
		}

		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {

				if (row == 1 && column == 2 || row == 1 && column == 1) {
					grid[row][column] = false;
				} else {
				}
				grid[row][column] = true;
			}
		}
	}

	private boolean findPaths(boolean[][] maze, int row, int column, ArrayList<Point> path) {

		if (row < 0 || column < 0 || !maze[row][column]) {
			return false;
		}

		boolean isAtOrigin = (row == 0) && (column == 0);

		if (isAtOrigin || findPaths(maze, row - 1, column, path) || findPaths(maze, row, column - 1, path)) {
			System.out.println(row + ", " + column);
			path.add(new Point(row, column));
			return true;
		}
		return false;
	}

	public ArrayList<Point> findPathsDynamicProgramming(int row, int column) {

		if (row == 0) {
			return null;
		}

		boolean[][] maze = new boolean[row][column];
		initializeArray(maze);

		ArrayList<Point> path = new ArrayList<Point>();
		// to cache failed Points
		HashSet<Point> failedPoints = new HashSet<Point>();

		if (findPathsDynamicProgramming(maze, row - 1, column - 1, path, failedPoints)) {
			return path;
		}

		return null;
	}

	private boolean findPathsDynamicProgramming(boolean[][] grid, int row, int column, ArrayList<Point> path,
			HashSet<Point> failedPoints) {

		if (row < 0 || column < 0 || !grid[row][column]) {
			return false;
		}

		Point p = new Point(row, column);
		// check the cached failed points
		if (failedPoints.contains(p)) {
			return false;
		}
		boolean isAtOrigin = (row == 0) && (column == 0);

		if (isAtOrigin || findPathsDynamicProgramming(grid, row - 1, column, path, failedPoints)
				|| findPathsDynamicProgramming(grid, row, column - 1, path, failedPoints)) {
			System.out.println(row + ", " + column);
			path.add(p);
			return true;
		}

		// cache the failed points
		failedPoints.add(p);
		return false;
	}
}
