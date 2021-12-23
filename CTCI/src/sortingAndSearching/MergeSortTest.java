/**
 * 
 */
package sortingAndSearching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 23-Dec-2021
 */
public class MergeSortTest {

	int[] array = { 2, 1, 4, 7, 5, 3, 8, 6 };
	int[] empty = new int[0];
	int[] invalid;
	int[] array2 = { 7, 6, 5, 5, 4, 3, 2, 1 };

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void mergeSortTest() {
		MergeSort.mergeSort(array);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
		MergeSort.mergeSort(empty);
		Assert.assertArrayEquals(new int[] {}, empty);
		MergeSort.mergeSort(invalid);
		Assert.assertArrayEquals(null, invalid);
		MergeSort.mergeSort(array2);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 5, 6, 7 }, array2);

	}

}
