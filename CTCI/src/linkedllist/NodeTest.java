package linkedllist;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NodeTest {

	Node linkedList;
	List<Integer> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		linkedList = new Node(0);
		linkedList.appendAtTail(1);
		linkedList.appendAtTail(2);
		linkedList.appendAtTail(0);
		list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(0);
	}

	@Test
	public void appendAtTailTest() {

		assertEquals(Node.createLinkedList(list), linkedList);
		linkedList.appendAtTail(4);
		list.add(4);
		assertEquals(Node.createLinkedList(list), linkedList);

	}

	@Test
	public void deleteNodeTest() {
		linkedList.appendAtTail(4);
		linkedList = linkedList.deleteNode(4, 4);
		assertEquals(Node.createLinkedList(list), linkedList);
	}

}
