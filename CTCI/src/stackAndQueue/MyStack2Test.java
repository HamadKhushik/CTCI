package stackAndQueue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyStack2Test {

	MyStack2<Integer> stack;
	MyStack2<Integer> empty;
	MyStack2<Integer> nullTest;

	@Before
	public void setUp() throws Exception {

		stack = new MyStack2<Integer>(2);
		empty = new MyStack2<Integer>(2);
	}

	@Test
	public void pushTest() {

		try {
			stack.push(1);
			assertEquals((Integer) 1, stack.peek());
			stack.push(2);
			assertEquals((Integer) 2, stack.peek());
			stack.push(3);
			nullTest.push(0);
			assertEquals(true, stack.isFull());
			assertEquals(false, empty.isFull());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void peekTest() {

		try {
			stack.push(1);
			assertEquals((Integer) 1, stack.peek());
			stack.push(2);
			assertEquals((Integer) 2, stack.peek());
			stack.push(3);
			empty.peek();
			assertEquals(true, stack.isFull());
			assertEquals(false, empty.isFull());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void isFullIsEmptyTest() {

		try {
			stack.push(1);
			stack.push(2);
			assertEquals(true, stack.isFull());
			assertEquals(false, empty.isFull());
			assertEquals(true, nullTest.isEmpty());
			assertEquals(false, nullTest.isFull());
			assertEquals(false, empty.isEmpty());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
