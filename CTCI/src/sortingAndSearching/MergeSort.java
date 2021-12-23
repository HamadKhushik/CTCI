/**
 * 
 */
package sortingAndSearching;

/**
 * Implementation of merge sort algorithm. Stable sorting algorithm as in order
 * of similar elements is retained. recursive algorithm. Time complexity
 * O(nlogn), space complexity O(n) source :
 * https://www.youtube.com/watch?v=0nlPxaC2lTw
 * 
 * @author Hammad: 23-Dec-2021
 */
public class MergeSort {

	public static void mergeSort(int[] array) {

		if (array == null || array.length <= 1) {
			return;
		}

		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int[] helper, int low, int high) {

		if (low >= high) {
			return;
		}

		int mid = low + (high - low) / 2;
		mergeSort(array, helper, low, mid);
		mergeSort(array, helper, mid + 1, high);
		merge(array, helper, low, mid, high);
	}

	private static void merge(int[] array, int[] helper, int low, int mid, int high) {

		// copy all elements to the helper array
		for (int i = 0; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low; // starting index for left sub array(helper)
		int helperRight = mid + 1; // starting index for right sub array(helper)
		int current = low; // index for the current element in the array

		while (helperLeft <= mid && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		// fill the remaining elements in the array in sorted order
		// if there are no elements left in the left sub array, all the elements are in
		// the sorted order
		int remaining = mid - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}
}
