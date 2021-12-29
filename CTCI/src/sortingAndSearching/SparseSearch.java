/**
 * 
 */
package sortingAndSearching;

/**
 * 10.5 search a string in an array of String which is sorted but interspersed
 * with empty strings. Solved using Binary Search (modified).
 * 
 * @author Hammad: 28-Dec-2021
 */
public class SparseSearch {

	public static int search(String[] array, String str) {

		if (array == null || array.length == 0 || str.length() == 0 || str == null) {
			return -1;
		}

		return search(array, str, 0, array.length - 1);
	}

	private static int search(String[] array, String str, int low, int high) {

		int mid = low + (high - low) / 2;

		if (array[mid].equals("")) {

			int left = mid - 1;
			int right = mid + 1;

			while (true) {

				if (left < low && right > high) {
					return -1;
				} else if (right <= high && !array[right].equals("")) {
					mid = right;
					break;
				} else if (left >= low && !array[left].equals("")) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}

		if (str.compareTo(array[mid]) > 0) { // search right
			return search(array, str, mid + 1, high);
		} else if (str.compareTo(array[mid]) < 0) { // search left
			return search(array, str, low, mid - 1);
		} else {
			return mid;
		}
	}

}
