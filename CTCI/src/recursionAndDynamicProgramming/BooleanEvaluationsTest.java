/**
 * 
 */
package recursionAndDynamicProgramming;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 21-Dec-2021
 */
public class BooleanEvaluationsTest {

	String s = "1^0|0|1";

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void countEvalTest() {
		System.out.println(BooleanEvaluations.countEval(s, false));

	}

}
