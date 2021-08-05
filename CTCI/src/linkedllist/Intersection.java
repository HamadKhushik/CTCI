package linkedllist;

/*
 * 2.6 -> determine if two linked lists intersect by reference
 * 
 * Note:
 * if two linked lists intersect, they will have a common tail
 */
public class Intersection {

	public Node findIntersetingNode(Node list1, Node list2) {

		if (list1 == null || list2 == null) {
			return null;
		}

		Result result1 = getLengthAndTail(list1);
		Result result2 = getLengthAndTail(list2);

		if (result1.tail != result2.tail) {
			return null;
		}

		Node shorter = result1.size < result2.size ? list1 : list2;
		Node longer = result1.size < result2.size ? list2 : list1;

		longer = incrementPointer(longer, Math.abs((result1.size - result2.size)));

		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		return shorter;
	}

	protected Node incrementPointer(Node head, int length) {

		Node curr = head;

		while (length > 0 && curr != null) {
			curr = curr.next;
			length--;
		}
		return curr;
	}

	protected Result getLengthAndTail(Node head) {

		if (head == null) {
			return null;
		}

		Node curr = head;
		int length = 1;

		while (curr.next != null) {
			length++;
			curr = curr.next;
		}

		return new Result(curr, length);
	}

	/* wrapper class to hold tail and size of list */
	class Result {

		Node tail;
		int size;

		public Result(Node tail, int size) {
			this.tail = tail;
			this.size = size;
		}

	}
}
