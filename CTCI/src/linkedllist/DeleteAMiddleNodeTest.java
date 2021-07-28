package linkedllist;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeleteAMiddleNodeTest {

	Node nodeList;
	List<Integer> list;
	Node emptyNode;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		list = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5 });
		nodeList = Node.createLinkedList(list);
		emptyNode = new Node(0);
	}

	@Test
	public void deleteElementMiddleTest() {
		assertEquals(true, DeleteAMiddleNode.deleteNodeMiddle(nodeList.next));
		assertEquals(true, DeleteAMiddleNode.deleteNodeMiddle(nodeList.next));
		assertEquals(true, DeleteAMiddleNode.deleteNodeMiddle(nodeList.next));
		assertEquals(true, DeleteAMiddleNode.deleteNodeMiddle(nodeList.next));
		emptyNode.appendAtTail(5);
		assertEquals(emptyNode, nodeList);
	}

}
