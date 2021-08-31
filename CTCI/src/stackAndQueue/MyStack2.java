package stackAndQueue;

import java.util.EmptyStackException;

/*
 * implementation of stack using linked list
 */
public class MyStack2<T> {

	int capacity;
	int size;
	Node<T> top;

	// constructor
	public MyStack2(int capacity) {

		this.capacity = capacity;
		size = 0;
		top = null;
	}

	/* push an element onto the stack */
	public void push(T value) throws Exception {

		if (isFull()) {
			throw new Exception("Stack is full");
		}

		Node<T> node = new Node<T>(value);
		node.next = top;
		top = node;
		size++;
	}

	/* remove the element at the top of stack */
	public T pop() throws EmptyStackException {

		if (isEmpty()) {
			throw new EmptyStackException();
		}

		T value = top.data;
		top = top.next;

		return value;
	}

	/* return the element at the top of stack without removing */
	public T peek() throws EmptyStackException {

		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return top.data;
	}

	/* check if the stack is at maximum capacity */
	public boolean isFull() {
		return size == capacity;
	}

	/* check if the stack is empty */
	public boolean isEmpty() {
		return top == null || size == 0;
	}

}

class Node<T> {

	protected T data;
	protected Node<T> next;

	public Node(T value) {
		this.data = value;
	}

}
