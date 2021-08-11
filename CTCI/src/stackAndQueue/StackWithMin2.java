package stackAndQueue;

/*
 * 3.2 finds the min element in a stack
 * this is slightly more space efficient
 * it uses another stack to store minimum values
 * as they are pushed in and popped out of stack 
 */
public class StackWithMin2 extends MyStack.StackNode<Integer> {

	// to store minimum values in a stack
	MyStack.StackNode<Integer> s1;

	public StackWithMin2(Integer data) {
		super(data);
		s1 = new MyStack.StackNode<Integer>(data);
	}

	/*
	 * if new value to be added to the stack is minimum push it to 's1' stack
	 */
	public void push(int value) {

		if (value <= min()) {
			s1.push(value);
		}
		super.push(value);
	}

	/*
	 * pop the element from original stack and if it is minimum value, pop it off s1
	 * stack too
	 */
	public Integer pop() {

		int value = super.pop();
		if (value == min()) {
			s1.pop();
		}
		return value;
	}

	/*
	 * s1 maintains the minimum value in the stack at the top
	 */
	public int min() {

		if (s1.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return s1.peek();
	}
}
