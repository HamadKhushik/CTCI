package linkedllist;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindKthElementTest {

	List<Integer> list;
	Integer[] array;
	int[] intArray;
	List<Integer> empty;
	Node nodeList;
	Node emptyNode;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		list = new LinkedList<Integer>();
		array = new Integer[] { 0, 1, 2, 3, 4, 5, 6 };
		intArray = new int[] { 0, 1, 2, 3, 4, 5, 6 };
		Collections.addAll(list, array);
		empty = new LinkedList<Integer>();
		nodeList = Node.createLinkedList(list);
		emptyNode = new Node(0);
	}

	@Test
	public void kthElementTest() {
		assertEquals(2, FindKthElement.kthElement(list, 5));
		assertEquals(-1, FindKthElement.kthElement(empty, 5));
		assertEquals(-1, FindKthElement.kthElement(list, 8));
		assertEquals(0, FindKthElement.kthElement(list, 7));
	}

	@Test
	public void kthElementTwwoPointerTest() {
		assertEquals(2, FindKthElement.kthElementTwoPointer(nodeList, 5));
		assertEquals(-1, FindKthElement.kthElementTwoPointer(emptyNode, 5));
		assertEquals(-1, FindKthElement.kthElementTwoPointer(nodeList, 8));
		assertEquals(0, FindKthElement.kthElementTwoPointer(nodeList, 7));
	}

	@Test
	public void kthElementTwwoPointerBookTest() {
		assertEquals(2, FindKthElement.kthElementTwoPointerBook(nodeList, 5));
		assertEquals(-1, FindKthElement.kthElementTwoPointerBook(emptyNode, 5));
		assertEquals(-1, FindKthElement.kthElementTwoPointerBook(nodeList, 8));
		assertEquals(0, FindKthElement.kthElementTwoPointerBook(nodeList, 7));
	}

}
