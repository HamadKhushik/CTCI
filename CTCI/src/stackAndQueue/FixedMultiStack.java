package stackAndQueue;

import java.util.EmptyStackException;

/*
 * 3.1 Implement 3 stacks using a single array 
 * solution implements stacks of fixed size/capacity
 * 
 * Note: Stack Numbers range from 0 -> 2
 */
public class FixedMultiStack {

	private int numberOfStacks = 3;
	private int capacity;
	private int[] values;
	private int[] sizes;

	// constructor
	public FixedMultiStack(int stackSize) {

		capacity = stackSize;
		values = new int[numberOfStacks * capacity];
		sizes = new int[numberOfStacks];
	}

	public void push(int stackNum, int item) throws Exception {

		if (isFull(stackNum)) {
			throw new Exception("Stack is full");
		}

		sizes[stackNum]++;
		values[topIndexOf(stackNum)] = item;
	}

	public int pop(int stackNum) throws EmptyStackException {

		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}

		int topIndex = topIndexOf(stackNum); // get top index
		int value = values[topIndex]; // get Value
		values[topIndex] = 0; // reset
		sizes[stackNum]--; // shrink stack

		return value;
	}

	public int peek(int stackNum) throws EmptyStackException {

		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}

		return values[topIndexOf(stackNum)];
	}

	public boolean isEmpty(int stackNum) {

		return sizes[stackNum] == 0;
	}

	// returns the index of top element of stack
	// in the sub-array
	public int topIndexOf(int stackNum) {

		int offset = stackNum * capacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

	public boolean isFull(int stackNum) {

		return sizes[stackNum] == capacity;
	}

	public int[] getValues() {
		return values;
	}
}
