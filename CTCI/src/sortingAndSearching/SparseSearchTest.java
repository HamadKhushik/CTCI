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
public class SparseSearchTest {

	String[] array1 = { "at", "", "", "", "ball", "", "", "call", "", "", "dad", "", "", "elf" };
	String[] empty = {};
	String[] invalid;
	String[] array2 = { "abc", "", "", "bcd", "", "cde" };

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void searchTest() {

		assertEquals(4, SparseSearch.search(array1, "ball"));

		assertEquals(13, SparseSearch.search(array1, "elf"));

		assertEquals(0, SparseSearch.search(array1, "at"));

		assertEquals(-1, SparseSearch.search(empty, "ball"));

		assertEquals(-1, SparseSearch.search(invalid, "ball"));

		assertEquals(3, SparseSearch.search(array2, "bcd"));

		assertEquals(5, SparseSearch.search(array2, "cde"));
	}

}
