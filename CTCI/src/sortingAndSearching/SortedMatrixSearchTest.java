/**
 * 
 */
package sortingAndSearching;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 03-Jan-2022
 */
public class SortedMatrixSearchTest {

	int[][] matrix = { { 15, 20, 40, 85 }, { 20, 35, 80, 95 }, { 30, 55, 95, 105 }, { 40, 80, 100, 120 } };

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(true, SortedMatrixSearch.naiveFind(matrix, 55));

		assertEquals(true, SortedMatrixSearch.naiveFind(matrix, 105));

		assertEquals(false, SortedMatrixSearch.naiveFind(matrix, 25));

		assertEquals(false, SortedMatrixSearch.naiveFind(matrix, 5));
	}

}
