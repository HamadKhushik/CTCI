/**
 * 
 */
package recursionAndDynamicProgramming;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 15-Dec-2021
 */
public class PermutationsWithDuplicatesTest {

	String testString = "aabc";
	PermutationsWithDuplicates testObject = new PermutationsWithDuplicates();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void pringPermutationsTest() {
		ArrayList<String> result = testObject.printPerms(testString);
		System.out.println("Total number of Permutations for String \"" + testString + "\" = " + result.size());
		System.out.println("Permutations are: " + result);
		System.out.println("null test " + testObject.printPerms(null));
	}

}
