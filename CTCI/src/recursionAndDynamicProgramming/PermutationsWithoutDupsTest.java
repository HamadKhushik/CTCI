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
		System.out.println(permutations + " - First Approach");
		assertEquals(checkerList, permutations);
		emptyList.add("");
		assertEquals(emptyList, testObject.getPerms(empty));
		assertNull(testObject.getPerms(null));
	}

	@Test
	public void getPerms2Test() {
		checkerList = new ArrayList<String>() {
			{
				add("abc");
				add("acb");
				add("bac");
				add("bca");
				add("cab");
				add("cba");
			}
		};
		ArrayList<String> permutations = testObject.getPerms2(str);
		System.out.println(permutations + " - Second Approach");
		assertEquals(checkerList, permutations);
		emptyList.add("");
		assertEquals(emptyList, testObject.getPerms2(empty));
		assertNull(testObject.getPerms2(null));
	}

	@Test
	public void getPerms3Test() {
		checkerList = new ArrayList<String>() {
			{
				add("abc");
				add("acb");
				add("bac");
				add("bca");
				add("cab");
				add("cba");
			}
		};
		ArrayList<String> permutations = testObject.getPerms3(str);
		System.out.println(permutations + " - Third Approach");
		assertEquals(checkerList, permutations);
		emptyList.add("");
		assertEquals(emptyList, testObject.getPerms3(empty));
		assertNull(testObject.getPerms3(null));
	}
}
