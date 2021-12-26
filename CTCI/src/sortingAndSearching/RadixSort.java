/**
 * 
 */
package sortingAndSearching;

/**
 * Implementation of Radix Sort Algorithm. It doesnt use comparisons to sort,
 * rather it uses individual digits for sorting. It uses Counting sort algorithm
 * in its implementation. Time Complexity = O(kn) where n is the number of
 * elements and k is the number of passes of the sorting algorithm
 * 
 * @author Hammad: 26-Dec-2021
 */
public class RadixSort {

	public static void radixSort(int[] array) {

		if (array == null || array.length == 0) {
			return;
		}

		int max = getMax(array);
		radixSort(array, max);

	}

	private static void radixSort(int[] array, int max) {

		// do Count Sort on all the levels/digits
		for (int exp = 1; max / exp > 0; exp *= 10) {
			CountSort.countSort(array, exp);
		}

	}

	public static int getMax(int[] array) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {

			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}

}
