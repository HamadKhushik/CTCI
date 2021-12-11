/**
 * 
 */
package recursionAndDynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 11-Dec-2021
 */
public class RecursiveMultiplicationTest {

	int a = 8;
	int b = 9;
	RecursiveMultiplication testObject = new RecursiveMultiplication();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void minProductTest() {
		assertEquals(72, testObject.minProduct(a, b));
		assertEquals(72, testObject.minProduct(b, a));
		assertEquals(0, testObject.minProduct(0, b));
		assertEquals(b, testObject.minProduct(1, b));
		assertEquals(27, testObject.minProduct(3, b));
	}

	@Test
	public void minProduct2Test() {
		assertEquals(72, testObject.minProduct2(a, b));
		assertEquals(72, testObject.minProduct2(b, a));
		assertEquals(0, testObject.minProduct2(0, b));
		assertEquals(b, testObject.minProduct2(1, b));
		assertEquals(27, testObject.minProduct2(3, b));
	}

	@Test
	public void minProduct3Test() {
		assertEquals(72, testObject.minProduct3(a, b));
		assertEquals(72, testObject.minProduct3(b, a));
		assertEquals(0, testObject.minProduct3(0, b));
		assertEquals(b, testObject.minProduct3(1, b));
		assertEquals(27, testObject.minProduct3(3, b));
	}

}
