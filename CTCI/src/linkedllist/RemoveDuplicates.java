package linkedllist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// removes the duplicate elements of a linkedList
public class RemoveDuplicates {

	public void removeDups(Node head) {

		Set<Integer> set = new HashSet<Integer>();
		// index of duplicate will be '1' with reference to 'n' => looping variable
		int index = 1;
		Node n = head;

		// set.add(n.data);
		while (n.next != null) {
			if (set.contains(n.next.data)) {
				n = n.deleteNode(index, n.next.data);
				if (n.next == null) {
					return;
				}

			} else {
				set.add(n.next.data);
			}
			n = n.next;
		}
	}

	// using Book solution and LinkedList class
	public void removeDupsBook(List<Integer> list) {

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (set.contains(list.get(i))) {
				list.remove(i);
			} else {
				set.add(list.get(i));
			}
		}
	}

	// using book solution and Node class
	public void removeDupsBookNode(Node head) {

		Node previous = new Node(0);
		Node n = head;
		Set<Integer> set = new HashSet<Integer>();

		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
}
