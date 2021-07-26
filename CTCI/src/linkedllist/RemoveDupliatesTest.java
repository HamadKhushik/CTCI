package linkedllist;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RemoveDupliatesTest {

	Node linkedList;
	List<Integer> list;
	List<Integer> listToRemoveDups;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		linkedList = new Node(0);
		linkedList.appendAtTail(1);
		linkedList.appendAtTail(1);
		linkedList.appendAtTail(2);
		linkedList.appendAtTail(3);
		linkedList.appendAtTail(3);
		list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		listToRemoveDups = new LinkedList<Integer>();
		listToRemoveDups.add(0);
		listToRemoveDups.add(1);
		listToRemoveDups.add(1);
		listToRemoveDups.add(2);
		listToRemoveDups.add(3);
		listToRemoveDups.add(3);
	}

	@Test
	public void removeDupsTest() {
		RemoveDuplicates rd = new RemoveDuplicates();
		assertEquals(Node.createLinkedList(list), linkedList);
		rd.removeDups(linkedList);
		list.remove(5);
		list.remove(1);
		assertEquals(Node.createLinkedList(list), linkedList);
	}

	@Test
	public void removeDupsBookTest() {
		RemoveDuplicates rd = new RemoveDuplicates();
		assertEquals(list, listToRemoveDups);
		rd.removeDupsBook(listToRemoveDups);
		list.remove(5);
		list.remove(1);
		assertEquals(list, listToRemoveDups);
	}

	@Test
	public void removeDupsBookNodeTest() {
		RemoveDuplicates rd = new RemoveDuplicates();
		assertEquals(Node.createLinkedList(list), linkedList);
		rd.removeDupsBookNode(linkedList);
		list.remove(5);
		list.remove(1);
		assertEquals(Node.createLinkedList(list), linkedList);
	}

	@Test
	public void removeDupsNoBufferTest() {
		RemoveDuplicates rd = new RemoveDuplicates();
		assertEquals(Node.createLinkedList(list), linkedList);
		rd.removeDupsNoBuffer(linkedList);
		list.remove(5);
		list.remove(1);
		assertEquals(Node.createLinkedList(list), linkedList);
	}

}
