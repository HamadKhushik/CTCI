/**
 * 
 */
package recursionAndDynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 10-Dec-2021
 */
public class MagicIndexTest {

	int[] array = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
	int[] array2 = { -40, -20, -1, 1, 2, 3, 5, 6, 7, 11, 12, 13 };
	int[] empty = null;
	int[] nonDistint = { -10, -5, 2, 2, 2, 3, 4, 5, 9, 12, 13 };
	MagicIndex testObject = new MagicIndex();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void MagiIndexBruteForceTest() {
		assertEquals(7, testObject.magicIndexBruteForce(array));
	}

	@Test
	public void MagiIndexTest() {
		assertEquals(7, testObject.magicIndex(array));
		assertEquals(-1, testObject.magicIndex(array2));
		assertEquals(-1, testObject.magicIndex(empty));
	}

	@Test
	public void MagiIndexOptimisedTest() {
		assertEquals(7, testObject.magicIndexOptimised(array));
		assertEquals(-1, testObject.magicIndexOptimised(array2));
		assertEquals(-1, testObject.magicIndexOptimised(empty));
		assertEquals(2, testObject.magicIndexOptimised(nonDistint));
	}

}
