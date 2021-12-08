package recursionAndDynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FibonacciSeriesTest {

	int n = 5;
	FibonacciSeries test = new FibonacciSeries();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void fibonacciRecursiveTest() {
		assertEquals(5, test.fibonacciRecursive(n));
	}

	@Test
	public void fibonacciDynamicTest() {
		assertEquals(5, test.fibonacciDynamic(n));
	}

	@Test
	public void fibonacciBottomUpTest() {
		assertEquals(5, test.fibonacciBottomUp(n));
	}

	@Test
	public void fibonacciBottomUpOptimisedTest() {
		assertEquals(5, test.fibonacciBottomUpOptimised(n));
	}

}
