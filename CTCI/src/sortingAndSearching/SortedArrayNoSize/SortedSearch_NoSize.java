/**
 * 
 */
package sortingAndSearching.SortedArrayNoSize;

/**
 * 10.4 search in a sorted array like data structure which doesnt have size()
 * method, however it does have a elementAt(i) method which returns -1 if 'i' is
 * out of bounds. Time Complexity = O(nlogn) because it takes O(nlogn) time to
 * find the size of the data structure and O(nlogn) to find the element. no
 * additional space is required.
 * 
 * @author Hammad: 28-Dec-2021
 */
public class SortedSearch_NoSize {

	public static int search(ListY listY, int x) {

		int index = 1;

		while (listY.elementAt(index) != -1 && x > listY.elementAt(index)) { // if x < array[index], it must be on the
																				// left side of the
			// index
			index *= 2;
		}
		// we only search between index/2 -> index, because we have already determined
		// in the previous iteration of while loop that x > array[index]
		return search(listY, x, index / 2, index);
	}

	private static int search(ListY listY, int x, int low, int high) {

		int mid;

		while (low <= high) {

			mid = low + (high - low) / 2;
			int middle = listY.elementAt(mid);

			if (x < middle || middle == -1) {
				high = mid - 1;
			} else if (x > middle) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
