/**
 * 
 */
package recursionAndDynamicProgramming;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 16-Dec-2021
 */
public class ParenthesesTest {

	int n = 3;
	Parentheses testObject = new Parentheses();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void generateParenthesesTest() {

		HashSet<String> result = testObject.generateParentheses(n);
		assertEquals(5, result.size());
		System.out.println("\n***********Dupliates calculated but filtered by HashSet***********");
		System.out.println(result.size() + " " + result);
	}

	@Test
	public void generateParentheses2Test() {

		ArrayList<String> result = testObject.generateParentheses2(n);
		assertEquals(5, result.size());
		System.out.println("\n***********Optimised - No Duplicates calculated******************");
		System.out.println(result.size() + " " + result);
	}

}
