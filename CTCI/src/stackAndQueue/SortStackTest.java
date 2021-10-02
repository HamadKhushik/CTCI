package stackAndQueue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SortStackTest {

	MyStack2<Integer> s1 = new MyStack2<Integer>();
	MyStack2<Integer> s2 = new MyStack2<Integer>();

	@Before
	public void setUp() throws Exception {

		try {
			s1.push(1);
			s1.push(10);
			s1.push(2);
			s1.push(9);
			s1.push(3);
			s1.push(8);
			s1.push(4);
			s1.push(0);

			s2.push(10);
			s2.push(9);
			s2.push(8);
			s2.push(4);
			s2.push(3);
			s2.push(2);
			s2.push(1);
			s2.push(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void sortTest() {
		SortStack stack = new SortStack();
		System.out.println("Sort Stack Test " + s1);
		stack.sort(s1);
		assertEquals(s1.pop(), s2.pop());
		assertEquals(s1.pop(), s2.pop());
		assertEquals(s1.pop(), s2.pop());
		assertEquals(s1.pop(), s2.pop());
		assertEquals(s1.pop(), s2.pop());
		assertEquals(s1.pop(), s2.pop());
		assertEquals(s1.pop(), s2.pop());
	}

}
