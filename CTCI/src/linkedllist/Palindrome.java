package linkedllist;

import java.util.Stack;

/*
 * 2.6 -> check if a linked list is Palindrome of itself
 */
public class Palindrome {

	/*
	 * brute force solution, O(n) time complexity & O(n) space complexity uses a
	 * stack to store the list and then re-create it
	 */
	public static boolean isPalindrome(Node head) {

		Stack<Integer> stack = new Stack();
		Node l1 = head;

		while (l1 != null) {
			stack.push(l1.data);
			l1 = l1.next;
		}

		Node result = new Node(0);
		Node l2 = result;
		while (!stack.isEmpty()) {
			Node curr = new Node(stack.pop());
			l2.next = curr;
			l2 = l2.next;
		}

		return (head == null ? result.next == null : result.next.equals(head));
	}

	/*
	 * more efficient solution, using O(n) time & O(1) space complexity Iterative
	 * solution Youtube Programming Tuturials
	 */
	public static boolean isPalindrome2(Node head) {

		Node fast = head;
		Node slow = head;
		Node prev = null;
		Node reconstructOriginal = null;

		// divide the list in half
		while (fast != null && fast.next != null) {

			fast = fast.next.next;

			Node curr = slow;
			slow = slow.next;

			// reverse the first half of the list
			curr.next = prev;
			prev = curr;
		}
		// to undo the changes made to original list
		head = slow;

		// if list has even no of elements
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			if (slow.data != prev.data) {
				return false;
			}
			slow = slow.next;

			Node curr = prev;
			prev = prev.next;

			// un-reverse the first half of the list
			curr.next = head;
			head = curr;
		}
		return (slow == null && prev == null);
	}

	/*
	 * solution in the book uses a stack to store the first half of list instead of
	 * reversing uses slow and fast pointer approach
	 */
	public static boolean isPalindrome3(Node head) {

		Node fast = head;
		Node slow = head;

		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.next != null) {
			fast = fast.next.next;

			stack.push(slow.data);
			slow = slow.next;
		}

		// if list has odd number of elements
		// ignore the middle element
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			if (slow.data != stack.pop()) {
				return false;
			}
			slow = slow.next;
		}

		return true;
	}

	/*
	 * book solution using recursion main method
	 */
	public static boolean isPalindromeRecursive(Node head) {

		int length = length(head);
		Result res = isPalindromeReurse(head, length);

		return res.result;
	}

	// helper function to recurse and hide the length implementation
	public static Result isPalindromeReurse(Node head, int len) {

		// base case
		if (head == null || len <= 0) {
			return (new Palindrome()).new Result(head, true);
		}
		// if length is odd, ignore middle element
		else if (len == 1) {
			return (new Palindrome()).new Result(head.next, true);
		}

		Result res = isPalindromeReurse(head.next, len - 2);

		// if child calls are not a Palindrome, return a failure
		if (!res.result || res.node == null) {
			return res;
		}

		// validate data
		res.result = (head.data == res.node.data);
		// return corresponding node
		res.node = res.node.next;

		return res;
	}

	public static int length(Node head) {
		int len = 0;
		Node l1 = head;

		while (l1 != null) {
			len++;
			l1 = l1.next;
		}
		return len;
	}

	// wrapper class to return multiple values
	class Result {

		Node node;
		boolean result;

		public Result(Node head, boolean bool) {
			node = head;
			result = bool;
		}
	}
}
