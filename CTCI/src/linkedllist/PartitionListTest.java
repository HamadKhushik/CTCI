package linkedllist;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PartitionListTest {

	Integer[] array;
	List<Integer> list;
	Node beforeNode;
	Node beforeNode2;
	List<Integer> afterList;
	Node afterNode;
	Node afterNode2;
	Node empty;

	@Before
	public void setUp() throws Exception {

		array = new Integer[] { 0, 1, 4, 3, 2, 5, 2 };
		list = Arrays.asList(array);
		beforeNode = Node.createLinkedList(list);
		array = new Integer[] { 0, 1, 2, 2, 4, 3, 5 };
		afterList = Arrays.asList(array);
		afterNode = Node.createLinkedList(afterList);
		array = new Integer[] { 2, 2, 1, 0, 4, 3, 5 };
		afterList = Arrays.asList(array);
		afterNode2 = Node.createLinkedList(afterList);
		array = new Integer[] { 5, 3, 4, 0, 1, 2, 2 };
		list = Arrays.asList(array);
		beforeNode2 = Node.createLinkedList(list);
		empty = new Node(0);
	}

	@Test
	public void listPartitioinTest() {
		beforeNode = PartitionList.listPartition(beforeNode, 7);
		assertEquals(beforeNode, beforeNode);
		beforeNode = PartitionList.listPartition(beforeNode, 3);
		assertEquals(afterNode, beforeNode);
		empty = PartitionList.listPartition(empty, 4);
		assertEquals(empty, empty);
	}

	@Test
	public void listPartitionBookTest() {
		beforeNode = PartitionList.listPartitionBook(beforeNode, 3);
		assertEquals(afterNode2, beforeNode);
		assertEquals(empty, empty);
		beforeNode = PartitionList.listPartitionBook(beforeNode, 7);
		assertEquals(beforeNode2, beforeNode);
	}

}
