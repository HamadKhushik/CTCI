/**
 * 
 */
package sortingAndSearching;

/**
 * 10.1 Sorted Merge. Merge two sorted arrays given that array A has enough
 * buffer at the end to hold all the elements in array B.
 * 
 * @author Hammad: 26-Dec-2021
 */
public class SortedMerge {

	public static void mergeArrays(int[] a, int[] b, int countA, int countB) {

		if (a == null || b == null || a.length < (countA + countB)) { // if a does not have enough buffer to hold all
																		// the elements in b
			return;
		}

		int mergedIndex = countA + countB - 1; // start from the end of the array a

		int indexA = countA - 1;
		int indexB = countB - 1;

		while (indexB >= 0) { // since we only have to copy elements of array B in array a
			if (indexA >= 0 && a[indexA] > b[indexB]) {
				a[mergedIndex] = a[indexA];
				indexA--;
			} else {
				a[mergedIndex] = b[indexB];
				indexB--;
			}
			mergedIndex--;
		}

	}

}
