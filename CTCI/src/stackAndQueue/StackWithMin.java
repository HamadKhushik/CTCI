package stackAndQueue;

/*
 * 3.2 returns the minimum value in stack
 * -> stores the min value of the stack in each node
 * -> uses 'n' extra integers to store 'n' min values
 */
public class StackWithMin extends MyStack.StackNode<NodeWithMin> {

	// constructor
	public StackWithMin(NodeWithMin data) {
		super(data);
	}

	public StackWithMin(int data) {
		super(new NodeWithMin(data, data));
	}

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public NodeWithMin pop() {
		return super.pop();
	}

	// return min value of top element of stack
	// which stores the min value of the stack
	public int min() {

		if (this.isEmpty()) {
			return Integer.MAX_VALUE; // error value
		}

		return peek().min;
	}

}

/*
 * wrapper class to hold the min value for stack
 */
class NodeWithMin {

	public int value;
	public int min;

	public NodeWithMin(int value, int min) {
		this.value = value;
		this.min = min;
	}
}