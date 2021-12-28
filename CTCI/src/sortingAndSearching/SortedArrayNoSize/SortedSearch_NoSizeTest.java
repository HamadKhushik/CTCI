/**
 * 
 */
package sortingAndSearching.SortedArrayNoSize;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import sortingAndSearching.QuickSort;

/**
 * @author Hammad: 28-Dec-2021
 */
public class SortedSearch_NoSizeTest {

	int[] array = { 2, 1, 4, 7, 5, 3, 8, 6 };
	ListY listArray1;

	int[] empty = new int[0];
	ListY listEmpty;

	int[] invalid;
	ListY listInvalid;

	int[] array2 = { 7, 6, 5, 5, 4, 3, 2, 1 };
	ListY listArray2;

	@Before
	public void setUp() throws Exception {
		QuickSort.quickSort(array);
		QuickSort.quickSort(array2);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));

		listArray1 = new ListY(array);
		listEmpty = new ListY(empty);
		listInvalid = new ListY(invalid);
		listArray2 = new ListY(array2);
	}

	@Test
	public void searchTest() {

		assertEquals(7, SortedSearch_NoSize.search(listArray1, 8));

		assertEquals(-1, SortedSearch_NoSize.search(listEmpty, 8));

		assertEquals(-1, SortedSearch_NoSize.search(listInvalid, 8));

		assertEquals(7, SortedSearch_NoSize.search(listArray2, 7));

		assertEquals(0, SortedSearch_NoSize.search(listArray2, 1));

		assertEquals(4, SortedSearch_NoSize.search(listArray2, 5));
	}

}
