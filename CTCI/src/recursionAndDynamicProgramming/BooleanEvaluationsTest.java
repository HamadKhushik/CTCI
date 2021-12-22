/**
 * 
 */
package recursionAndDynamicProgramming;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 21-Dec-2021
 */
public class BooleanEvaluationsTest {

	String s = "0^0&0^1|1";
	String s2 = "1^0|0|1";
	String s3 = "1";
	String s4 = "";
	String s5 = null;

	HashMap<String, Integer> map = new HashMap<String, Integer>();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void countEvalTest() {
		assertEquals(10, BooleanEvaluations.countEval(s, true));
		assertEquals(2, BooleanEvaluations.countEval(s2, false));
		assertEquals(0, BooleanEvaluations.countEval(s3, false));
		assertEquals(1, BooleanEvaluations.countEval(s3, true));
		assertEquals(0, BooleanEvaluations.countEval(s4, false));
		assertEquals(0, BooleanEvaluations.countEval(s4, true));
		assertEquals(0, BooleanEvaluations.countEval(s5, false));

	}

	@Test
	public void countEvalOptimisedTest() {
		assertEquals(10, BooleanEvaluations.countEval(s, true, map));
		assertEquals(2, BooleanEvaluations.countEval(s2, false, map));
		assertEquals(0, BooleanEvaluations.countEval(s3, false, map));
		assertEquals(1, BooleanEvaluations.countEval(s3, true, map));
		assertEquals(0, BooleanEvaluations.countEval(s4, false, map));
		assertEquals(0, BooleanEvaluations.countEval(s4, true, map));
		assertEquals(0, BooleanEvaluations.countEval(s5, false, map));

	}

}
