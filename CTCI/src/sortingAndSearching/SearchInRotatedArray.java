/**
 * 
 */
package sortingAndSearching;

/**
 * 10.3 search an element in a sorted array that has been rotated. solution is
 * based on a slight modification of Binary Search. time complexity is O(log n)
 * - if the all the elements in the array are unique. where 'n' is the number of
 * elements in the array, and O(n) if the array contains duplicated elements
 * because both right and left sub-arrays will need to be searched.
 * 
 * @author Hammad: 28-Dec-2021
 */
public class SearchInRotatedArray {

	public static int searchRotatedArray(int[] array, int x) {

		if (array == null || array.length == 0) {
			return -1;
		}

		return searchRotatedArray(array, x, 0, array.length - 1);
	}

	private static int searchRotatedArray(int[] array, int x, int low, int high) {

		if (low > high) {
			return -1;
		}

		int mid = low + (high - low) / 2;

		if (array[mid] == x) {
			return mid;
		}

		if (array[low] < array[mid]) { // left is normally ordered
			if (x >= array[low] && x < array[mid]) { // since left is normally ordered and 'x' is between array[left]
														// and
														// array[mid], search left
				return searchRotatedArray(array, x, low, mid - 1);
			} else { // if 'x' is not between array[low] and array[mid] it might be on the right
				return searchRotatedArray(array, x, mid + 1, high);
			}
		} else if (array[mid] < array[high]) { // right is normally ordered
			if (x > array[mid] && x <= array[high]) { // since right is normally ordered and 'x' is between array[mid]
														// and array[high], search right
				return searchRotatedArray(array, x, mid + 1, high);
			} else { // if 'x' is not between array[low] and array[high], it might be on the left
				return searchRotatedArray(array, x, low, mid - 1);
			}
		}

		else { // if array contains duplicates

			int location = -1;
			if (array[mid] == array[low]) { // left sub-array might contain all duplicates, search on right
				location = searchRotatedArray(array, x, mid + 1, high);
			}
			if (location == -1 && array[mid] == array[high]) { // if its not on the right, it might be on the left.
																// also, if array[mid] == array[low] == array[high], we
																// must search both left and right sub-arrays
				location = searchRotatedArray(array, x, low, mid - 1);
			}
			return location;
		}

	}

}
