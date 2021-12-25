/**
 * 
 */
package sortingAndSearching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 25-Dec-2021
 */
public class CountingSortTest {

	int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	int[] empty = new int[0];
	int[] nullarray;
	int[] array2 = { 5, 4, 6, 4, 3, 5 };

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		CountSort.countSort(array, 1);
		// Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, array);

		CountSort.countSort(empty, 1);
		Assert.assertArrayEquals(new int[] {}, empty);

		CountSort.countSort(nullarray, 1);
		Assert.assertArrayEquals(null, nullarray);

		CountSort.countSort(array2, 1);
		Assert.assertArrayEquals(new int[] { 3, 4, 4, 5, 5, 6 }, array2);
	}

}
