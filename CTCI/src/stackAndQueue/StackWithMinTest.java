package stackAndQueue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StackWithMinTest {

	StackWithMin stack1;
	StackWithMin empty;

	@Before
	public void setUp() throws Exception {
		stack1 = new StackWithMin(5);
		empty = new StackWithMin(null);
//		stack1.push(6);
//		stack1.push(3);
//		stack1.push(7);
	}

	@Test
	public void pushTest() {
		assertEquals(5, stack1.min());
		stack1.push(6);
		assertEquals(5, stack1.min());
		stack1.push(3);
		assertEquals(3, stack1.min());
		stack1.push(7);
		assertEquals(3, stack1.min());
		stack1.pop();
		assertEquals(3, stack1.min());
		stack1.pop();
		assertEquals(5, stack1.min());
		assertEquals(Integer.MAX_VALUE, empty.min());
	}

}
