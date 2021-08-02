package linkedllist;

/*
 * CTCI 2.5
 * Calculate the sum of two linked lists in reverse order
 * eg: (2 -> 4 -> 3) + (5 -> 6 -> 4) = 342 + 465
 * result = 7 -> 0 -> 8 = 807
 * Note: first element in the list is the least significant bit
 * carry over will be taken from first element in the list 
 * to last element in the list
 */
public class SumLists {

	// Nick White solution- Youtube
	public static Node addTwoLists(Node l1, Node l2) {

		Node head = new Node(0);
		Node result = head;

		int carry = 0;

		while (l1 != null || l2 != null) {

			int l1Data = (l1 != null) ? l1.data : 0;
			int l2Data = (l2 != null) ? l2.data : 0;
			int sum = l1Data + l2Data + carry;
			carry = sum / 10;
			int lastDigit = sum % 10;
			Node newNode = new Node(lastDigit);
			result.next = newNode;

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
			result = result.next;
		}

		if (carry > 0) {
			Node curr = new Node(carry);
			result.next = curr;
			result = result.next;
		}

		return head.next;
	}

	/*
	 * Solution in the book using recursion
	 */

	public static Node addTwoListsRecursive(Node l1, Node l2) {

		// to hide the carry implementation from user
		return addLists(l1, l2, 0);
	}

	private static Node addLists(Node l1, Node l2, int carry) {

		// base case
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		// recursive
		Node result = new Node(0);
		int value = carry;
		value += (l1 != null) ? l1.data : 0;
		value += (l2 != null) ? l2.data : 0;

		result.data = value % 10;
		Node more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value / 10 > 0 ? value / 10 : 0);

		result.next = more;

		return result;
	}

	/*
	 * part 'b' of the problem Linked Lists are not in the reverse order i-e 7 -> 1
	 * -> 6 = 716 5 -> 9 -> 2 = 592 result = 1 -> 3 -> 0 -> 8 = 1308 Recursive
	 * solution in the book
	 */
	public static Node addListsForwardOrder(Node l1, Node l2) {

		int len1 = length(l1);
		int len2 = length(l2);

		if (len1 > len2) {
			l2 = addPadding(l2, len1 - len2);
		} else {
			l1 = addPadding(l1, len2 - len1);
		}

		PartialSum sum = addListsHelper(l1, l2);

		if (sum.carry == 0) {
			return sum.sum;
		} else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	// helper method to recurse
	protected static PartialSum addListsHelper(Node l1, Node l2) {

		// base case
		if (l1 == null && l2 == null) {
			SumLists x = new SumLists();
			PartialSum sum = x.new PartialSum();
			return sum;
		}

		// recursive case
		PartialSum sum = addListsHelper(l1.next, l2.next);

		int val = sum.carry + l1.data + l2.data;
		// insert the result
		Node fullResult = insertBefore(sum.sum, val % 10);

		sum.sum = fullResult;
		sum.carry = val / 10;

		return sum;
	}

	// returns the length of the list
	protected static int length(Node l1) {

		int length = 0;
		while (l1 != null) {
			length++;
			l1 = l1.next;
		}
		return length;
	}

	// helper functions to add zeros if the length of two lists are not equal
	protected static Node addPadding(Node list, int number) {

		Node head = list;
		for (int i = 0; i < number; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}

	// helper method to insert an element before head
	protected static Node insertBefore(Node list, int data) {

		Node node = new Node(data);
		if (list != null) {
			node.next = list;
		}

		return node;
	}

	// wrapper lass to hold a list head and carry value
	class PartialSum {
		Node sum = null;
		int carry = 0;
	}
}
