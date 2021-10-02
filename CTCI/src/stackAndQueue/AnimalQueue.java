package stackAndQueue;

import java.util.LinkedList;

/*
 *  3.6 Animal shelter
 */

public class AnimalQueue {

	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order = 0;

	public void enqueue(AnimalShelter a) {

		a.setOrder(order);
		order++;

		if (a instanceof Cat) {
			cats.addLast((Cat) a);
		} else if (a instanceof Dog) {
			dogs.addLast((Dog) a);
		}
	}

	// return the oldest animal i-e cat/dog
	public AnimalShelter dequeue() {

		if (dogs.size() == 0) {
			return dequeueCat();
		} else if (cats.size() == 0) {
			return dequeueDog();
		}

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (cat.isOlderThan(dog)) {
			return dequeueCat();
		} else {
			return dequeueDog();

		}
	}

	public Dog dequeueDog() {
		return dogs.poll();
	}

	public Cat dequeueCat() {
		return cats.poll();
	}

	public static void main(String[] args) {
		AnimalQueue queue = new AnimalQueue();
		AnimalShelter d = new Dog("test dog");
		queue.enqueue(d);
		System.out.println(d.getOrder());

		AnimalShelter dog = queue.dequeue();
		System.out.println("dog name: " + d.getName());

	}

}
