/**
 * 
 */
package recursionAndDynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 09-Dec-2021
 */
public class TripleStepTest {

	int n = 5;
	TripleStep test = new TripleStep();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void countWaysTest() {
		assertEquals(13, test.countWays(n));
	}

	@Test
	public void countWaysMemoizationTest() {
		assertEquals(13, test.countWaysMemoization(n));
	}
}
