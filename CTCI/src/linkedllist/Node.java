package linkedllist;

// Node class for the linked List implementation
public class Node {

	private Node next = null;
	private int data;
	private int size;

	public Node(int d) {
		data = d;
		size = 1;
	}

	public void appendAtTail(int d) {

		Node end = new Node(d);
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}

		n.next = end;
		this.size++;
	}

	// delete a node from singly linked list
	public void deleteNode(int d) {

		Node n = this;
		if (n.next == null) {
			return;
		}

		if (n.data == d) {
			n = n.next;
			this.size--;
			return;
		}

		while (n.next != null) {

			if (n.next.data == d) {
				n.next = n.next.next;
				this.size--;
				return;
			}
			n = n.next;
		}
	}

	public int getSize() {
		return size;
	}

}