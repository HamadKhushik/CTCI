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
public class SortedMergeTest {

	int[] aArray = new int[6];
	int[] bArray = { 2, 4, 6 };
	int[] cArray = { 2, 14, 45 };
	int[] dArray = new int[6];

	@Before
	public void setUp() throws Exception {
		aArray[0] = 1;
		aArray[1] = 3;
		aArray[2] = 5;

		dArray[0] = 1;
		dArray[1] = 3;
		dArray[2] = 5;
	}

	@Test
	public void mergeArraysTest() {

		SortedMerge.mergeArrays(aArray, bArray, 3, 3);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, aArray);

		SortedMerge.mergeArrays(dArray, cArray, 3, 3);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 5, 14, 45 }, dArray);

		cArray = new int[] { 2, 14, 45, 67 };
		int[] eArray = new int[3];
		SortedMerge.mergeArrays(eArray, cArray, 0, 4);
		Assert.assertArrayEquals(new int[3], eArray);

	}

}
