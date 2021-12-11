/**
 * 
 */
package recursionAndDynamicProgramming;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 11-Dec-2021
 */
public class PowerSetTest {

	ArrayList<Integer> set = new ArrayList<Integer>() {
		{
			add(1);
			add(2);
		}
	};

	PowerSet testObject = new PowerSet();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getSubsetsTest() {
		ArrayList<ArrayList<Integer>> listOfList = listOfList();
		// check
		assertEquals(listOfList, testObject.getSubsets(set, 0));
	}

	@Test
	public void getSubsets2Test() {
		System.out.println(testObject.getSubsets2(set));
	}

	// helper method to return set of all subsets to check against the solution
	private ArrayList<ArrayList<Integer>> listOfList() {
		ArrayList<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subset = new ArrayList<Integer>();
		listOfList.add(subset);
		for (int i = 2; i > 0; i--) {
			subset = new ArrayList<Integer>();
			subset.add(i);
			listOfList.add(subset);
		}
		subset = new ArrayList<Integer>();
		subset.add(2);
		subset.add(1);
		listOfList.add(subset);

		return listOfList;
	}
}
