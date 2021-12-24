/**
 * 
 */
package sortingAndSearching;

/**
 * Implementation of Quick Sort Algorithm. Time Complexity O(nlogn) in average
 * case and O(n2) in worst case Space complexity O(log n) because of recursive
 * calls
 * 
 * @author Hammad: 24-Dec-2021
 */
public class QuickSort {

	public static void quickSort(int[] array) {

		if (array == null || array.length == 0) {
			return;
		}

		quickSort(array, 0, array.length - 1);

	}

	private static void quickSort(int[] array, int left, int right) {

		if (left >= right) {
			return;
		}

		int index = partition(array, left, right);

		if (left < (index - 1)) { // Base Case. more than one element in the sub array - recurse
			quickSort(array, left, index - 1);
		}

		if (index < right) { // Base case. if partition is valid - recurse
			quickSort(array, index, right);
		}

	}

	private static int partition(int[] array, int left, int right) {

		int pivot = array[left + (right - left) / 2]; // find pivot - it can be on any deterministic position. in this
														// case we are using mid point

		while (left <= right) {

			while (array[left] < pivot) { // if the numbers on the left are smaller than pivot/ find number greater than
				// pivot in the left sub-array
				left++;
			}
			while (array[right] > pivot) { // find a number smaller than pivot on the right sub-array
				right--;
			}

			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left; // left will be the partition point for the array
	}

	private static void swap(int[] array, int left, int right) {

//		array[left] = array[left] + array[right];
//		array[right] = array[left] - array[right];
//		array[left] = array[left] - array[right];

		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
