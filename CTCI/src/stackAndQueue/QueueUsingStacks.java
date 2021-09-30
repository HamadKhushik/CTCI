package stackAndQueue;

/*	3.4 Queue using two stacks
 * implementation of queue using two stacks
 * 
 * */

public class QueueUsingStacks<T> {

	private MyStack2<T> s1; // stores the new elements
	private MyStack2<T> s2; // stores the old elements to be removed

	public QueueUsingStacks() {
		s1 = new MyStack2<T>();
		s2 = new MyStack2<T>();
		int size;
	}

	// element is always added in the s1 stack
	public void enqueue(T data) {

		try {
			s1.push(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// removing an element from queue
	// elements are copied over to s2 and to element is removed
	public T dequeue() {

		if (!s2.isEmpty()) {
			return s2.pop();
		}

		if (s1.isEmpty()) {
			return null;
		}

		while (!s1.isEmpty()) {
			try {
				s2.push(s1.pop());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return s2.pop();
	}

	public int size() {
		return s1.size + s2.size;
	}

}
