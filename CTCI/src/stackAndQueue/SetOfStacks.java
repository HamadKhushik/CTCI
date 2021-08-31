package stackAndQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/*
 * 3.3 Stack of Plates
 * Implement a set of stacks to mimic real life stak of plates
 * if one stack exceeds the threshold value, start a new stack 
 */
public class SetOfStacks {

	int capacity = 5;
	List<MyStack2<Integer>> stacks = new ArrayList<MyStack2<Integer>>(capacity);

	public void push(int value) throws Exception {

		MyStack2<Integer> last = getLastStack();

		if (last != null || !last.isFull()) {
			last.push((Integer.valueOf(value)));
		}
		// create new stack
		else {
			MyStack2<Integer> stack = new MyStack2(capacity);
			stack.push(Integer.valueOf(value));
			stacks.add(stack);
		}
	}

	/* removes and returns the first element in the stack */
	public int pop() throws EmptyStackException {

		MyStack2<Integer> last = getLastStack();

		if (last == null) {
			throw new EmptyStackException();
		}
		int value = last.pop();

		// if no more elements in the last stack
		if (last.isEmpty()) {
			stacks.remove(stacks.size() - 1);
		}
		return value;
	}

	/* returns the last stack in the list */
	public MyStack2<Integer> getLastStack() {

		return stacks.get(stacks.size() - 1);
	}

}

//	public boolean isFull(MyStack.StackNode<Integer> stack) {
//
//		if (stack.size() == capacity) {
//			return true;
//		}
//		return false;
//	}