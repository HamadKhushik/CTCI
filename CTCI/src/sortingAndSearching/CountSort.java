/**
 * 
 */
package sortingAndSearching;

/**
 * Implementation of Count Sort Algorithm - used in the Radix sort Algorithm
 * 
 * @author Hammad: 25-Dec-2021
 */
public class CountSort {

	public static void countSort(int[] array, int exp) {

		if (array == null || array.length == 0) {
			return;
		}

		int n = array.length;
		int[] output = new int[n];
		int[] count = new int[10]; // considering we are using base 10

		// update the frequency of each digit
		for (int i = 0; i < n; i++) {
			count[(array[i] / exp) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			output[count[(array[i] / exp) % 10] - 1] = array[i];
			count[(array[i] / exp) % 10]--;
		}

		// copy all elements of output[] to array[]
		System.arraycopy(output, 0, array, 0, (n - 1));
	}

}
