/**
 * 
 */
package sortingAndSearching.groupAnagrams;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 27-Dec-2021
 */
public class GroupAnagramsTest {

	String[] array = { "abc", "def", "aab", "cab", "bac" };
	String[] array2 = {};
	String[] nullArray = null;
	String[] noAnagrams = { "abc", "def", "ghi", "jkl" };

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void groupAnagramsTest() {

		String[] sortedArray = { "aab", "abc", "cab", "bac", "def" };
		GroupAnagrams.groupAnagrams(array);
		Assert.assertArrayEquals(sortedArray, array);

		GroupAnagrams.groupAnagrams(array2);
		Assert.assertArrayEquals(new String[0], array2);

		GroupAnagrams.groupAnagrams(nullArray);
		Assert.assertArrayEquals(null, nullArray);

		sortedArray = new String[] { "abc", "def", "ghi", "jkl" };
		GroupAnagrams.groupAnagrams(noAnagrams);
		Assert.assertArrayEquals(sortedArray, noAnagrams);
	}

	@Test
	public void groupAnagramsUsingMapTest() {

		String[] sortedArray = { "abc", "cab", "bac", "aab", "def" };
		GroupAnagrams.groupAnagramsUsingMap(array);
		Assert.assertArrayEquals(sortedArray, array);

		GroupAnagrams.groupAnagramsUsingMap(array2);
		Assert.assertArrayEquals(new String[0], array2);

		GroupAnagrams.groupAnagramsUsingMap(nullArray);
		Assert.assertArrayEquals(null, nullArray);

		sortedArray = new String[] { "abc", "def", "ghi", "jkl" };
		GroupAnagrams.groupAnagramsUsingMap(noAnagrams);
		Assert.assertArrayEquals(sortedArray, noAnagrams);
	}

}
