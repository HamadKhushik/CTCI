package linkedllist;

import java.util.List;

// Node class for the linked List implementation
// a very basic implementation of linkedList
public class Node {

	protected Node next = null;
	protected int data;

	public Node(int d) {
		data = d;
	}

	// add a Node at tail
	public void appendAtTail(int d) {

		Node end = new Node(d);
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}

		n.next = end;
	}

	// overloaded method to take in a node element
	public void appendAtTail(Node d) {

		Node n = this;

		while (n.next != null) {
			n = n.next;
		}

		n.next = d;
	}

	// delete a node from singly linked list
	public Node deleteNode(int position, int d) {

		// get a reference to head
		Node n = this;
		int index = 1;
		if (n.next == null && n.data == d) {
			return null;
		}
		while (n.next != null) {

			if (n.next.data == d && index == position) {
				n.next = n.next.next;
				return this;
			}
			index++;
			n = n.next;
		}
		return this;
	}

	public static Node createLinkedList(List<Integer> list) {

		if (list.size() < 1) {
			return null;
		}
		Node linkedList = new Node(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			linkedList.appendAtTail(list.get(i));
		}

		return linkedList;
	}

	public void printList(Node head) {

		if (head == null) {
			return;
		}
		Node n = head;

		while (n.next != null) {
			System.out.print(n.data + ", ");
			n = n.next;
		}
		System.out.print(n.data + "\n");
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}
}