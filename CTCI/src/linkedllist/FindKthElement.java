package linkedllist;

import java.util.List;

public class FindKthElement {

	// find the size of the list and return kth to last element
	public static int kthElement(List<Integer> head, int k) {

		List<Integer> n = head;
		int size = 0;

		// compute the size of LinkedList
		for (int i : n) {
			size++;
		}

		if (size < 1 || k < 1 || k > size) {
			return -1;
		}

		// index is kth to last element
		int index = size - k + 1;
		size = 0;

		// if its kth to last element, return the element
		for (int i : n) {
			size++;
			if (size == index) {
				return i;
			}
		}

		return 0;
	}

	// two pointer approach
	public static int kthElementTwoPointer(Node head, int k) {

		Node pointer1 = head;
		Node pointer2 = head;
		int diff = 0;

		while (pointer1 != null) {
			// if difference between pointer1 and pointer2
			// is k, start updating pointer2
			if (diff >= k) {
				pointer2 = pointer2.next;
			}
			pointer1 = pointer1.next;
			diff++;
		}
		if (k > diff || diff < 1) {
			return -1;
		}

		return pointer2.data;
	}

	// two pointer book solution, cleaner solution
	public static int kthElementTwoPointerBook(Node head, int k) {

		Node pointer1 = head;
		Node pointer2 = head;

		for (int i = 0; i < k; i++) {
			if (pointer1 == null) {
				return -1;
			}
			pointer1 = pointer1.next;
		}

		while (pointer1 != null) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return pointer2.data;
	}
}
