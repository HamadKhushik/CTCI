package stackAndQueue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class QueueUsingStacksTest {

	QueueUsingStacks<Integer> queue = new QueueUsingStacks<Integer>();

	@Before
	public void setUp() throws Exception {

		queue.enqueue(7);
		queue.enqueue(5);
		queue.enqueue(3);
	}

	@Test
	public void EnqueueTest() {

		assertEquals(3, queue.size());
		queue.enqueue(4);
		assertEquals(4, queue.size());

	}

	@Test
	public void DequeueTest() {

		assertEquals(queue.dequeue(), (Integer) 7);
		assertEquals(queue.dequeue(), (Integer) 5);
		queue.enqueue(8);
		queue.enqueue(10);
		assertEquals(queue.dequeue(), (Integer) 3);
		assertEquals(queue.dequeue(), (Integer) 8);
		assertEquals(queue.dequeue(), (Integer) 10);

	}

}
