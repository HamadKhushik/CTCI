/**
 * 
 */
package recursionAndDynamicProgramming;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 8.10 - paint fill problem. Fill all the neighbouring cells in a 2D array with
 * the new color(if the original color is the same)
 * 
 * @author Hammad: 16-Dec-2021
 */

public class PaintFill {

	enum Color {
		BLACK, WHITE, RED, YELLOW, GREEN
	}

	public boolean fill(Color[][] image, int row, int column, Color newColor) {

		if (image[row][column] == newColor) {
			return false;
		}

		// for dfs - uncomment following line
		// return fill(image, row, column, image[row][column], newColor);

		// for bfs - uncomment following lines
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(column, row)); // because X-coordinate represent columns/horizontal axis and vice versa
		return fillbfs(image, row, column, image[row][column], newColor, queue);
	}

	// fills the image using dfs
	private boolean fill(Color[][] image, int r, int c, Color oldColor, Color newColor) {

		// base case - if the index is out of bounds or color is not the same - Return
		if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != oldColor) {
			return false;
		}

		image[r][c] = newColor;
		fill(image, r - 1, c, oldColor, newColor);
		fill(image, r + 1, c, oldColor, newColor);
		fill(image, r, c - 1, oldColor, newColor);
		fill(image, r, c + 1, oldColor, newColor);

		return true;
	}

	// iterative bfs method
	private boolean fillbfs(Color[][] image, int r, int c, Color oldColor, Color newColor, Queue<Point> queue) {

		// 2D array for direction, to update the index in four directions of 2D array
		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		// bfs
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			image[(int) point.getY()][(int) point.getX()] = newColor;

			for (int[] dir : dirs) { // to search all the neighbouring cells
				int row = (int) point.getY() + dir[0];
				int col = (int) point.getX() + dir[1];

				// if the index is invalid or color is not the same as original color
				if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != oldColor)
					continue;
				queue.add(new Point(col, row));
			}
		}
		return true;
	}
}
