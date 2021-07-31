package linkedllist;

/*
 * Partition list according to a number x such that all the 
 * smaller numbers are on the left and all the greater and equal
 * numbers are on the right
 */
public class PartitionList {

	/*
	 * use two separate lists and insert smaller elements in one list and greater
	 * elements in other list merge the lists in the end
	 */
	public static Node listPartition(Node head, int x) {

		if (head == null || head.next == null) {
			return head;
		}

		Node beforeHead = new Node(0);
		Node before = beforeHead;
		Node afterHead = new Node(0);
		Node after = afterHead;
		Node n = head;

		while (n != null) {
			if (n.data < x) {
				before.next = n;
				before = before.next;
			} else {
				after.next = n;
				after = after.next;
			}
			n = n.next;
		}
		after.next = null;
		before.next = afterHead.next;

		return beforeHead.next;
	}

	/*
	 * optimised solution in the book, uses only two variables order of the list
	 * changes adds elements to the head and tail of the list instead of making two
	 * lists and merging them together
	 */
	public static Node listPartitionBook(Node head, int x) {

		Node newHead = head;
		Node tail = head;

		Node curr = head;
		while (curr != null) {
			Node next = curr.next;

			// if elements is less than data, insert it to head
			if (curr.data < x) {
				curr.next = newHead;
				newHead = curr;
			} else {
				// else insert node at tail
				tail.next = curr;
				tail = tail.next;
			}

			curr = next;
		}
		tail.next = null;
		// head has moved, so return newHead
		return newHead;
	}
}
