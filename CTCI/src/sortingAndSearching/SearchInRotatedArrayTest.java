/**
 * 
 */
package sortingAndSearching;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 28-Dec-2021
 */
public class SearchInRotatedArrayTest {

	int[] array1 = { 70, 75, 17, 18, 30, 31, 35, 50, 60 };
	int[] array2 = { 24, 25, 26, 27, 30, 31, 13, 18, 23 };
	int[] array3 = { 30, 35, 36, 37, 30, 31, 13, 18, 30 };
	int[] array4 = { 30, 35, 36, 37, 30, 31, 13, 18, 24 };
	int[] array5 = { 40, 45, 46, 47, 50, 11, 13, 18, 24 };

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void searchRotatedArrayTest() {
		assertEquals(5, SearchInRotatedArray.searchRotatedArray(array1, 31));

		assertEquals(8, SearchInRotatedArray.searchRotatedArray(array2, 23));

		assertEquals(1, SearchInRotatedArray.searchRotatedArray(array3, 35));

		assertEquals(4, SearchInRotatedArray.searchRotatedArray(array4, 30));

		assertEquals(7, SearchInRotatedArray.searchRotatedArray(array5, 18));
	}

}
