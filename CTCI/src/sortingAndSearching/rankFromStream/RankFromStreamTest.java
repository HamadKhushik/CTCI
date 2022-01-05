/**
 * 
 */
package sortingAndSearching.rankFromStream;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 05-Jan-2022
 */
public class RankFromStreamTest {

	RankFromStream testObject = new RankFromStream();

	RankFromStream testObject2 = new RankFromStream();

	@Before
	public void setUp() throws Exception {
		testObject.track(20);
		testObject.track(15);
		testObject.track(25);
		testObject.track(10);
		testObject.track(23);
		testObject.track(5);
		testObject.track(13);
		testObject.track(24);

		int[] array = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };
		for (int i : array) {
			testObject2.track(i);
		}
	}

	@Test
	public void getRankTest() {
		assertEquals(6, testObject.getRank(24));

		assertEquals(7, testObject.getRank(25));

		assertEquals(3, testObject.getRank(15));

		assertEquals(0, testObject2.getRank(1));

		assertEquals(1, testObject2.getRank(3));

		assertEquals(3, testObject2.getRank(4));

		assertEquals(5, testObject2.getRank(5));

	}

}
