/**
 * 
 */
package sortingAndSearching;

/**
 * Implementation of Binary Search Algorithm
 * 
 * @author Hammad: 26-Dec-2021
 */
public class BinarySearch {

	public static int binarySearch(int[] array, int x) {

		if (array == null) {
			return -1;
		}

		int low = 0;
		int high = array.length - 1;
		int mid;

		while (low <= high) {

			mid = low + (high - low) / 2;

			if (x > array[mid]) {
				low = mid + 1;
			} else if (x < array[mid]) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int binarySearchRecursive(int[] array, int x) {

		if (array == null || array.length == 0) {
			return -1;
		}

		return binarySearchRecursive(array, x, 0, array.length - 1);
	}

	public static int binarySearchRecursive(int[] array, int x, int low, int high) {

		if (low > high) {
			return -1;
		}

		int mid = low + (high - low) / 2;

		if (x > array[mid]) {
			return binarySearchRecursive(array, x, mid + 1, high);
		} else if (x < array[mid]) {
			return binarySearchRecursive(array, x, low, mid - 1);
		} else {
			return mid;
		}

	}

}
