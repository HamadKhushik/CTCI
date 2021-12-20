/**
 * 
 */
package recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 18-Dec-2021
 */
public class EightQueensTest {

	int n = 2;
	Integer[] array = new Integer[n];
	EightQueens testObject = new EightQueens();
	ArrayList<Integer[]> result = new ArrayList<Integer[]>();

	@Before
	public void setUp() throws Exception {
		Arrays.fill(array, 0);
	}

	@Test
	public void test() {
		testObject.placeQueen(0, array, result);
		System.out.println(result.size());
		for (int i = 0; i < result.size() - 1; i++) {
			System.out.println(Arrays.deepToString(result.get(i)));
		}
	}

}
