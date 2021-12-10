/**
 * 
 */
package recursionAndDynamicProgramming;

/**
 * 8.3 Implement a Magic Index in an array such that array[i] = i
 * 
 * @author Hammad: 10-Dec-2021
 */
public class MagicIndex {

	public int magicIndexBruteForce(int[] array) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * implemented using Binary Search - assuming all elements in the array are
	 * distinct
	 */
	public int magicIndex(int[] array) {

		if (array == null) {
			return -1;
		}

		return magicIndex(array, 0, array.length - 1);
	}

	private int magicIndex(int[] array, int start, int end) {

		if (end < start) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (array[mid] == mid) {
			return mid;
		}
		// if number at mid index is greater, it must be on the left side of array
		else if (array[mid] > mid) {
			return magicIndex(array, start, mid - 1);
		}
		// if number at mid index is less than mid, it must be on the right side
		else {
			return magicIndex(array, mid + 1, end);
		}
	}

	// if the elements in the array are non-distinct
	public int magicIndexOptimised(int[] array) {

		if (array == null) {
			return -1;
		}

		return magicIndexOptimised(array, 0, array.length);
	}

	private int magicIndexOptimised(int[] array, int start, int end) {

		if (end < start) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (array[mid] == mid) {
			return mid;
		}

		// search left
		int leftIndex = Math.min(array[mid], mid - 1);
		int left = magicIndexOptimised(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}

		// search Right
		int rightIndex = Math.max(array[mid], mid + 1);
		int right = magicIndexOptimised(array, rightIndex, end);

		// if magic Index is not on left, return whatever is found on right
		return right;

	}
}
