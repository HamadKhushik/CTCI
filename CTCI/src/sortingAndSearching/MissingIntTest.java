/**
 * 
 */
package sortingAndSearching;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 30-Dec-2021
 */
public class MissingIntTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findMissingTest() {
//		MissingInt.findMissing();
	}

	// Does not work!!
	@Test
	public void missingInt2Test() {
		int[] array = MissingInt.generateRandomArray();
		System.out.println(Arrays.toString(array));
		System.out.println(MissingInt.missingInt2(array));
	}

}
