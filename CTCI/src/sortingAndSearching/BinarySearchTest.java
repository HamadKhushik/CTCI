/**
 * 
 */
package sortingAndSearching;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 26-Dec-2021
 */
public class BinarySearchTest {

	int[] array = { 19, 28, 7, 156, 3215, 54, 33, 82, 91 };
	int[] array2 = { 1, 2, 3, 4, 5, 6, 6, 7, 8 };
	int[] empty = new int[0];
	int[] nullarray;
	int[] array3 = { 15, 114, 1236, 14, 123, 15 };

	@Before
	public void setUp() throws Exception {
		RadixSort.radixSort(array);
		RadixSort.radixSort(array2);
		RadixSort.radixSort(array3);
//		System.out.println(Arrays.toString(array));
//		System.out.println(Arrays.toString(array2));

	}

	@Test
	public void binarySearchTest() {
		assertEquals(8, BinarySearch.binarySearch(array, 3215));

		assertEquals(-1, BinarySearch.binarySearch(array2, 9));

		assertEquals(-1, BinarySearch.binarySearch(empty, 3215));

		assertEquals(-1, BinarySearch.binarySearch(nullarray, 3215));

		assertEquals(2, BinarySearch.binarySearch(array3, 15));

		assertEquals(3, BinarySearch.binarySearch(array, 33));

	}

	@Test
	public void binarySearchRecursiveTest() {

		assertEquals(8, BinarySearch.binarySearchRecursive(array, 3215));

		assertEquals(-1, BinarySearch.binarySearchRecursive(array2, 9));

		assertEquals(-1, BinarySearch.binarySearchRecursive(empty, 3215));

		assertEquals(-1, BinarySearch.binarySearchRecursive(nullarray, 3215));

		assertEquals(2, BinarySearch.binarySearchRecursive(array3, 15));

		assertEquals(3, BinarySearch.binarySearchRecursive(array, 33));

	}

}
