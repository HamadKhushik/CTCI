package linkedllist;

/*
 * 2.8 -> given a linked list, detect if there is a loop
 * in the list, if yes, return the node at the starting 
 * of loop
 * 
 *  -> implements Floyds loop detection algorithm
 *  O(n) time complexity and O(1) space complexity
 */
public class DetectLoop {

	// returns the Node at the start of the list
	public Node findBeginingofLoop(Node head) {

		Node fast = head;
		Node slow = isLoop(head);

		if (slow == null) {
			return null;
		}

		// find the collision point, which is start of loop
		while (slow != fast) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	// checks if the list contains a loop
	// using two pointer approach
	// and return the collision point
	public Node isLoop(Node head) {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {

			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}

}
