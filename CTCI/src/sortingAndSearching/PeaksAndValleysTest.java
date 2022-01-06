/**
 * 
 */
package sortingAndSearching;

import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 06-Jan-2022
 */
public class PeaksAndValleysTest {

	int[] array;
	int[] array2;
	int[] array3;
	int[] empty;
	int[] nullArray;

	@Before
	public void setUp() throws Exception {
		array = new int[] { 5, 8, 6, 2, 3, 4, 6 };
		array2 = new int[] { 9, 1, 0, 4, 8, 7 };
		array3 = new int[] { 5, 3, 1, 2, 3 };
		empty = new int[0];
	}

	@Test
	public void sortValleyPeakTest() {
		PeaksAndValleys.sortValleyPeak(array);
		Assert.assertArrayEquals(new int[] { 3, 2, 5, 4, 6, 6, 8 }, array);

		PeaksAndValleys.sortValleyPeak(array2);
		Assert.assertArrayEquals(new int[] { 1, 0, 7, 4, 9, 8 }, array2);

		PeaksAndValleys.sortValleyPeak(array3);
		Assert.assertArrayEquals(new int[] { 2, 1, 3, 3, 5 }, array3);

		PeaksAndValleys.sortValleyPeak(empty);
		Assert.assertArrayEquals(new int[] {}, empty);

		PeaksAndValleys.sortValleyPeak(nullArray);
		assertNull(null, nullArray);
	}

	@Test
	public void sortValleyPeakOptimalTest() {
		PeaksAndValleys.sortValleyPeakOptimal(array);
		Assert.assertArrayEquals(new int[] { 5, 8, 2, 6, 3, 6, 4 }, array);

		PeaksAndValleys.sortValleyPeakOptimal(array2);
		Assert.assertArrayEquals(new int[] { 1, 9, 0, 8, 4, 7 }, array2);

		PeaksAndValleys.sortValleyPeakOptimal(array3);
		Assert.assertArrayEquals(new int[] { 3, 5, 1, 3, 2 }, array3);

		PeaksAndValleys.sortValleyPeakOptimal(empty);
		Assert.assertArrayEquals(new int[] {}, empty);

		PeaksAndValleys.sortValleyPeakOptimal(nullArray);
		assertNull(null, nullArray);
	}

}
