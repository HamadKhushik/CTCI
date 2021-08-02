package recursion.marty.stepp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculateExponentTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void PowerTest() {
		assertEquals(32, CalculateExponent.power(2, 5));
		assertEquals(25, CalculateExponent.power(5, 2));
		assertEquals(9, CalculateExponent.power(3, 2));
		assertEquals(1, CalculateExponent.power(2, 0));
		assertEquals(0, CalculateExponent.power(2, -5));
	}

}
