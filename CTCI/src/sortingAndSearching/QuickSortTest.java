/**
 * 
 */
package sortingAndSearching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 24-Dec-2021
 */
public class QuickSortTest {

	int[] array = { 2, 1, 4, 7, 5, 3, 8, 6 };
	int[] empty = new int[0];
	int[] invalid;
	int[] array2 = { 7, 6, 5, 5, 4, 3, 2, 1 };

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void mergeSortTest() {
		QuickSort.quickSort(array);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, array);
		QuickSort.quickSort(empty);
		Assert.assertArrayEquals(new int[] {}, empty);
		QuickSort.quickSort(invalid);
		Assert.assertArrayEquals(null, invalid);
		QuickSort.quickSort(array2);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 5, 6, 7 }, array2);

	}

}
