/**
 * 
 */
package recursionAndDynamicProgramming;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 12-Dec-2021
 */
public class PermutationsWithoutDupsTest {

	String str = "abc";
	PermutationsWithoutDups testObject = new PermutationsWithoutDups();
	String empty = "";
	ArrayList<String> emptyList = new ArrayList<String>();
	ArrayList<String> checkerList = new ArrayList<String>() {
		{
			add("abc");
			add("bac");
			add("bca");
			add("acb");
			add("cab");
			add("cba");
		}
	};

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getPermsTest() {
		ArrayList<String> permutations = testObject.getPerms(str);
		System.out.println(permutations);
		assertEquals(checkerList, permutations);
		emptyList.add("");
		assertEquals(emptyList, testObject.getPerms(empty));
		assertNull(testObject.getPerms(null));
	}

}
