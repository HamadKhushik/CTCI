package stackAndQueue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FixedMultiStackTest {

	FixedMultiStack stack1;
	FixedMultiStack stack2;
	FixedMultiStack empty;

	@Before
	public void setUp() throws Exception {
		stack1 = new FixedMultiStack(3);
		stack2 = new FixedMultiStack(5);
		empty = new FixedMultiStack(0);
	}

	@Test
	public void pushTest() {
		try {
			stack1.push(0, 9);
			stack1.push(1, 18);
			stack1.push(2, 27);
			stack1.push(2, 28);
			// assertEquals(new int[] { 9, 0, 0, 18, 0, 0, 27, 28 }, stack1.getValues());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void popTest() {

		try {
			assertEquals(28, stack1.pop(2));
			assertEquals(27, stack1.pop(2));
			assertEquals(18, stack1.pop(1));
			assertEquals(9, stack1.pop(0));
			assertEquals(28, stack1.pop(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void peekTest() {

		try {
			assertEquals(28, stack1.peek(2));
			assertEquals(28, stack1.peek(2));
			assertEquals(18, stack1.peek(1));
			assertEquals(18, stack1.peek(1));
			assertEquals(18, stack1.peek(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
