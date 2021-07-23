package linkedllist;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NodeTest {

	Node linkedList;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		linkedList = new Node(0);
		linkedList.appendAtTail(1);
		linkedList.appendAtTail(2);
		linkedList.appendAtTail(0);
	}

	@Test
	public void appendAtTailTest() {

		assertEquals(4, linkedList.getSize());
		linkedList.appendAtTail(4);
		assertEquals(5, linkedList.getSize());

	}

	@Test
	public void deleteNodeTest() {
		linkedList.deleteNode(0);
		assertEquals(3, linkedList.getSize());
	}

}
