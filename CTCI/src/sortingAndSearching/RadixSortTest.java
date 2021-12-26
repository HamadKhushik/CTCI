/**
 * 
 */
package sortingAndSearching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 26-Dec-2021
 */
public class RadixSortTest {

	int[] array = { 19, 28, 7, 156, 3215, 54, 33, 82, 91 };
	int[] empty = new int[0];
	int[] nullarray;
	int[] array2 = { 15, 114, 1236, 14, 123, 15 };

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		RadixSort.radixSort(array);
		Assert.assertArrayEquals(new int[] { 7, 19, 28, 33, 54, 82, 91, 156, 3215 }, array);

		RadixSort.radixSort(empty);
		Assert.assertArrayEquals(new int[] {}, empty);

		RadixSort.radixSort(nullarray);
		Assert.assertArrayEquals(null, nullarray);

		RadixSort.radixSort(array2);
		Assert.assertArrayEquals(new int[] { 14, 15, 15, 114, 123, 1236 }, array2);
	}

}
