package linkedllist;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SumListsTest {

	Integer[] array = new Integer[] { 2, 4, 3 };
	Integer[] array2 = new Integer[] { 5, 6, 4 };
	Integer[] result = new Integer[] { 7, 0, 8 };
	List<Integer> list = Arrays.asList(array);
	Node l1 = Node.createLinkedList(list);
	Node l2 = Node.createLinkedList(Arrays.asList(array2));
	Node l3 = Node.createLinkedList(Arrays.asList(result));

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void addTwoListsTest() {
		assertEquals(l3, SumLists.addTwoLists(l1, l2));

		array = new Integer[] { 1, 2, 3, 4, 5 };
		array2 = new Integer[] { 6, 7, 8 };
		result = new Integer[] { 7, 9, 1, 5, 5 };
		l1 = Node.createLinkedList(Arrays.asList(array));
		l2 = Node.createLinkedList(Arrays.asList(array2));
		l3 = Node.createLinkedList(Arrays.asList(result));
		assertEquals(l3, SumLists.addTwoLists(l1, l2));

		array = new Integer[] { 7, 1, 6 };
		array2 = new Integer[] { 5, 9, 2 };
		result = new Integer[] { 2, 1, 9 };
		l1 = Node.createLinkedList(Arrays.asList(array));
		l2 = Node.createLinkedList(Arrays.asList(array2));
		l3 = Node.createLinkedList(Arrays.asList(result));
		assertEquals(l3, SumLists.addTwoLists(l1, l2));
	}

	@Test
	public void addTwoListsRecursiveTest() {
		assertEquals(l3, SumLists.addTwoListsRecursive(l1, l2));

		array = new Integer[] { 1, 2, 3, 4, 5 };
		array2 = new Integer[] { 6, 7, 8 };
		result = new Integer[] { 7, 9, 1, 5, 5 };
		l1 = Node.createLinkedList(Arrays.asList(array));
		l2 = Node.createLinkedList(Arrays.asList(array2));
		l3 = Node.createLinkedList(Arrays.asList(result));
		assertEquals(l3, SumLists.addTwoListsRecursive(l1, l2));

		array = new Integer[] { 7, 1, 6 };
		array2 = new Integer[] { 5, 9, 2 };
		result = new Integer[] { 2, 1, 9 };
		l1 = Node.createLinkedList(Arrays.asList(array));
		l2 = Node.createLinkedList(Arrays.asList(array2));
		l3 = Node.createLinkedList(Arrays.asList(result));
		assertEquals(l3, SumLists.addTwoListsRecursive(l1, l2));
	}

	@Test
	public void lengthTest() {
		assertEquals(3, SumLists.length(l1));
		assertEquals(3, SumLists.length(l2));
		assertEquals(3, SumLists.length(l3));
	}

	@Test
	public void insertBeforeTest() {
		array2 = new Integer[] { 1, 2, 4, 3 };
		l2 = Node.createLinkedList(Arrays.asList(array2));
		assertEquals(l2, SumLists.insertBefore(l1, 1));

		array2 = new Integer[] { 1, 1, 2, 4, 3 };
		l2 = Node.createLinkedList(Arrays.asList(array2));
		l1 = SumLists.insertBefore(l1, 1);
		assertEquals(l2, SumLists.insertBefore(l1, 1));

		array2 = new Integer[] { 9, 1, 1, 2, 4, 3 };
		l2 = Node.createLinkedList(Arrays.asList(array2));
		l1 = SumLists.insertBefore(l1, 1);
		assertEquals(l2, SumLists.insertBefore(l1, 9));
	}

	@Test
	public void addPaddingTest() {
		array2 = new Integer[] { 0, 2, 4, 3 };
		l2 = Node.createLinkedList(Arrays.asList(array2));
		l1 = SumLists.addPadding(l1, 1);
		assertEquals(l2, l1);

		array2 = new Integer[] { 0, 0, 0, 0, 2, 4, 3 };
		l2 = Node.createLinkedList(Arrays.asList(array2));
		l1 = SumLists.addPadding(l1, 3);
		assertEquals(l2, l1);

		array2 = new Integer[] { 7, 0, 8 };
		l2 = Node.createLinkedList(Arrays.asList(array2));
		SumLists.addPadding(l3, 0);
		assertEquals(l2, l3);
	}

	@Test
	public void addListsForwardOrderTest() {
		array2 = new Integer[] { 8, 0, 7 };
		l3 = Node.createLinkedList(Arrays.asList(array2));
		assertEquals(l3, SumLists.addListsForwardOrder(l1, l2));

		array = new Integer[] { 1, 2, 3, 4, 5 };
		array2 = new Integer[] { 6, 7, 8 };
		result = new Integer[] { 1, 3, 0, 2, 3 };
		l1 = Node.createLinkedList(Arrays.asList(array));
		l2 = Node.createLinkedList(Arrays.asList(array2));
		l3 = Node.createLinkedList(Arrays.asList(result));
		assertEquals(l3, SumLists.addListsForwardOrder(l1, l2));

		array = new Integer[] { 7, 1, 6 };
		array2 = new Integer[] { 5, 9, 2 };
		result = new Integer[] { 1, 3, 0, 8 };
		l1 = Node.createLinkedList(Arrays.asList(array));
		l2 = Node.createLinkedList(Arrays.asList(array2));
		l3 = Node.createLinkedList(Arrays.asList(result));
		assertEquals(l3, SumLists.addListsForwardOrder(l1, l2));
	}
}
