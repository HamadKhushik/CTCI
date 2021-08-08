package stackAndQueue;

import java.util.EmptyStackException;

/*
 * implementation of Stack Data Structure
 */
public class MyStack<T> {

	public static class StackNode<T> {

		private T data;
		private StackNode<T> next;

		// constructor
		public StackNode(T data) {
			this.data = data;
		}

		private StackNode<T> top;

		// removes and returns the top element
		public T pop() {

			if (top == null)
				throw new EmptyStackException();

			T item = top.data;
			top = top.next;

			return item;
		}

		// inserts an element at the top of the stack
		public void push(T data) {

			StackNode<T> node = new StackNode<T>(data);

			node.next = top;
			top = node;
		}

		// returns the element at the top of the stack
		public T peek() {

			if (top == null)
				throw new EmptyStackException();

			return top.data;
		}

		public boolean isEmpty() {
			return top == null;
		}
	}

}
