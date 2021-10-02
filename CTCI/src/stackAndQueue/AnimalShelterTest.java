package stackAndQueue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AnimalShelterTest {

	AnimalQueue queue = new AnimalQueue();
	AnimalShelter dog = new Dog("dog 1");
	AnimalShelter cat = new Cat("cat 2");

	AnimalQueue empty = new AnimalQueue();

	@Before
	public void setUp() throws Exception {
		queue.enqueue(dog);
		queue.enqueue(cat);
		dog = new Dog("dog 3");
		cat = new Cat("cat 4");
		queue.enqueue(dog);
		queue.enqueue(cat);
		dog = new Dog("dog 5");
		cat = new Cat("cat 6");
		queue.enqueue(dog);
		queue.enqueue(cat);

	}

	@Test
	public void enqueueTest() {
		empty.enqueue(new Dog("empty test"));
		assertEquals("empty test", empty.dequeue().toString());
		empty.enqueue(new Dog("dog 1"));

		empty.enqueue(new Cat("cat 1"));
		empty.enqueue(new Dog("dog 2"));

		assertEquals("dog 1", empty.dequeue().toString());
		assertEquals("cat 1", empty.dequeue().toString());
		assertEquals("dog 2", empty.dequeueDog().toString());
	}

	@Test
	public void dequeueTest() {

		assertEquals("dog 1", queue.dequeue().toString());
		assertEquals("cat 2", queue.dequeue().toString());
		assertEquals("dog 3", queue.dequeueDog().toString());

		assertEquals("cat 4", queue.dequeueCat().toString());
		assertEquals("cat 6", queue.dequeueCat().toString());
		assertEquals("dog 5", queue.dequeue().toString());
	}

}
