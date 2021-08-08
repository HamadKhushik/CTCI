package stackAndQueue;

import java.util.NoSuchElementException;

/*
 * implementation of Queue Data Structure 
 */
public class MyQueue<T> {

	public static class QueueNode<T> {

		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}

		private QueueNode<T> first;
		private QueueNode<T> last;

		// add an element at the end of the queue
		public void add(T data) {

			QueueNode<T> node = new QueueNode(data);

			if (last != null) {
				last.next = node;
			}

			last = node;
			// if queue is empty
			if (first == null) {
				first = last;
			}
		}

		// remove the first element in the list
		public T remove() {

			if (first == null)
				throw new NoSuchElementException();

			T item = first.data;
			first = first.next;

			if (first == null) {
				last = null;
			}

			return item;
		}

// return the first element in the list
		public T peek() {

			if (first == null)
				throw new NoSuchElementException();

			return first.data;
		}

	}

}
