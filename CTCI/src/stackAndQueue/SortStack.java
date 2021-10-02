package stackAndQueue;

/*
 * 3.5 Sort Stack
 * sorts the stack using one extra stack
 * time complexity O(n2)
 * space complexity O(n)
 */
public class SortStack {

	// temporary stack
	private MyStack2<Integer> s2 = new MyStack2<Integer>();

	// constructor
	public SortStack() {
		s2 = new MyStack2<Integer>();
	}

	public void sort(MyStack2<Integer> s1) {

		while (!s1.isEmpty()) {
			int temp = s1.pop();

			// keep stack s2 sorted
			while (!s2.isEmpty() && s2.peek() > temp) {
				try {
					s1.push(s2.pop());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			try {
				s2.push(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// copy the sorted elements in the original stack
		while (!s2.isEmpty()) {
			try {
				s1.push(s2.pop());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public MyStack2<Integer> getStack() {
		return s2;
	}

}
