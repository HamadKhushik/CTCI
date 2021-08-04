package linkedllist;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {

	Integer[] array;
	Node list1;
	Integer[] array2;
	Node list2;
	Integer[] empty;
	Node emptyList;

	@Before
	public void setUp() throws Exception {

		array = new Integer[] { 1, 2, 3, 2, 1 };
		list1 = Node.createLinkedList(Arrays.asList(array));

		array2 = new Integer[] { 1, 2, 3, 3, 2, 1 };
		list2 = Node.createLinkedList(Arrays.asList(array2));

		empty = new Integer[] {};
		emptyList = Node.createLinkedList(Arrays.asList(empty));
	}

	@Test
	public void isPalindromeTest() {
		assertEquals(true, Palindrome.isPalindrome(list1));
		assertEquals(true, Palindrome.isPalindrome(list2));
		assertEquals(true, Palindrome.isPalindrome(emptyList));

		array = new Integer[] { 1, 2, 3, 4, 2, 1 };
		list1 = Node.createLinkedList(Arrays.asList(array));
		assertEquals(false, Palindrome.isPalindrome(list1));

		array = new Integer[] { 1, 2, 3, 4, 3, 1 };
		list1 = Node.createLinkedList(Arrays.asList(array));
		assertEquals(false, Palindrome.isPalindrome(list1));
	}

	@Test
	public void isPalindrome2Test() {
		assertEquals(true, Palindrome.isPalindrome2(list1));
		assertEquals(true, Palindrome.isPalindrome2(list2));
		assertEquals(true, Palindrome.isPalindrome2(emptyList));

		array = new Integer[] { 1, 2, 3, 4, 2, 1 };
		list1 = Node.createLinkedList(Arrays.asList(array));
		assertEquals(false, Palindrome.isPalindrome2(list1));

		array = new Integer[] { 1, 2, 3, 4, 3, 1 };
		list1 = Node.createLinkedList(Arrays.asList(array));
		assertEquals(false, Palindrome.isPalindrome2(list1));
	}

	@Test
	public void isPalindrome3Test() {
		assertEquals(true, Palindrome.isPalindrome3(list1));
		assertEquals(true, Palindrome.isPalindrome3(list2));
		assertEquals(true, Palindrome.isPalindrome3(emptyList));

		array = new Integer[] { 1, 2, 3, 4, 2, 1 };
		list1 = Node.createLinkedList(Arrays.asList(array));
		assertEquals(false, Palindrome.isPalindrome3(list1));

		array = new Integer[] { 1, 2, 3, 4, 3, 1 };
		list1 = Node.createLinkedList(Arrays.asList(array));
		assertEquals(false, Palindrome.isPalindrome3(list1));
	}

	@Test
	public void isPalindromeRecursiveTest() {
		assertEquals(true, Palindrome.isPalindromeRecursive(list1));
		assertEquals(true, Palindrome.isPalindromeRecursive(list2));
		assertEquals(true, Palindrome.isPalindromeRecursive(emptyList));

		array = new Integer[] { 1, 2, 3, 4, 2, 1 };
		list1 = Node.createLinkedList(Arrays.asList(array));
		assertEquals(false, Palindrome.isPalindromeRecursive(list1));

		array = new Integer[] { 1, 2, 3, 4, 3, 1 };
		list1 = Node.createLinkedList(Arrays.asList(array));
		assertEquals(false, Palindrome.isPalindromeRecursive(list1));
	}

}
