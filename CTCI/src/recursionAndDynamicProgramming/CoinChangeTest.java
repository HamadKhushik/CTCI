/**
 * 
 */
package recursionAndDynamicProgramming;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 18-Dec-2021
 */
public class CoinChangeTest {

	int[] denoms = { 25, 10, 5, 1 };
	CoinChange testObject = new CoinChange();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(testObject.makeChange(29, denoms));
		System.out.println(testObject.makeChange2(29, denoms));
	}

}
