/**
 * 
 */
package sortingAndSearching;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

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
		MissingInt.findMissing(10);
	}

	@Test
	public void findMissing3Test() throws FileNotFoundException {
		int missing = MissingInt.findMissing(new File("data/input2.txt"));
		assertEquals(7, missing);
	}

	// Does not work!!
//	@Test
//	public void missingInt2Test() {
//		int[] array = MissingInt.generateRandomArray();
//		System.out.println(Arrays.toString(array));
//		System.out.println(MissingInt.missingInt2(array));
//	}

}
