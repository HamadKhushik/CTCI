/**
 * 
 */
package sortingAndSearching;

import java.util.Arrays;

/**
 * 10.11 sort an array in such a way that its elements form peaks and valleys
 * 
 * @author Hammad: 06-Jan-2022
 */
public class PeaksAndValleys {

	// This is sub-optimal, as it sorts in ascending order before sorting in Peaks
	// and Valleys
	public static void sortValleyPeak(int[] array) {

		if (array == null || array.length < 1) {
			return;
		}

		Arrays.sort(array);
		for (int i = 1; i < array.length; i += 2) {
			swap(array, i - 1, i);
		}
	}

	private static void swap(int[] array, int first, int second) {

		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

	// does not need sorting in ascending order to sort an array in peaks and
	// valleys
	// sorts the max value in the middle element of the current window
	public static void sortValleyPeakOptimal(int[] array) {

		if (array == null || array.length < 1) {
			return;
		}

		for (int i = 1; i < array.length; i += 2) {
			int largestIndex = findLargest(array, i - 1, i, i + 1);

			if (i != largestIndex) {
				swap(array, i, largestIndex);
			}
		}
	}

	private static int findLargest(int[] array, int left, int mid, int right) {

		int len = array.length;
		int leftValue = left >= 0 && left < len ? array[left] : Integer.MIN_VALUE;
		int midValue = mid >= 0 && mid < len ? array[mid] : Integer.MIN_VALUE;
		int rightValue = right >= 0 && right < len ? array[right] : Integer.MIN_VALUE;

		int max = Math.max(leftValue, Math.max(midValue, rightValue));
		if (max == leftValue) {
			return left;
		} else if (max == midValue) {
			return mid;
		} else {
			return right;
		}

	}

}
