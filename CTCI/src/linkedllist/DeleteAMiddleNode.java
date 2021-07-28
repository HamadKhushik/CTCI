package linkedllist;

public class DeleteAMiddleNode {

	// delete a middle node in a linked list,
	// with access only to that node
	public static boolean deleteNodeMiddle(Node toDelete) {

		// this solution will NOT work for last element in the linked list
		if (toDelete == null || toDelete.next == null) {
			return false;
		}

		Node next = toDelete.next;
		toDelete.data = next.data;
		toDelete.next = next.next;

		return true;
	}
}
