package treesAndGraphs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class RandomNodeTest {

	RandomNode random = new RandomNode();
	RNode node = new RNode();

	@Before
	public void setUp() throws Exception {

		node.insert(node, 2);
		node.insert(node, 1);
		node.insert(node, 3);
		node.insert(node, 0);
		node.insert(node, 4);
	}

	@Test
	public void inssertTest() {
//		node.printTree(node);
		assertEquals((Integer) 2, node.value);
		assertEquals((Integer) 1, node.left.value);
		assertEquals((Integer) 0, node.left.left.value);
		assertEquals((Integer) 3, node.right.value);
		assertEquals((Integer) 4, node.right.right.value);
	}

	@Test
	public void findTest() {
		RNode found = node.find(node, 3);
		assertEquals((Integer) 3, found.value);

		found = node.find(node, 0);
		assertEquals((Integer) 0, found.value);

		found = node.find(node, 4);
		assertEquals((Integer) 4, found.value);
	}

	@Test
	public void deleteTest() {
		node.printTree(node);
		RNode found = node.delete(node, 4);
		assertNull(found.right.right);

		found = node.delete(node, 1);
		assertEquals((Integer) 0, found.left.value);
		assertNull(found.left.left);

		found.insert(node, 10);
		found.insert(node, 7);
		found.insert(node, 6);
		found.insert(node, 12);
//		found.printTree(node);
		found = node.delete(node, 10);
		assertEquals((Integer) 7, found.right.right.value);
//		found.printTree(node);

		found = node.delete(node, 2);
		assertEquals((Integer) 0, found.value);
	}

	@Test
	public void insertInOrderTest() {

		node = new RNode(2);
		node.insertInOrder(node, 1);
		node.insertInOrder(node, 3);
		node.insertInOrder(node, 0);
		node.insertInOrder(node, 4);

		RNode found = node.find(node, 3);
		assertEquals(2, found.size);
		assertEquals((Integer) 4, found.right.value);
		assertNull(found.left);

		found = node.find(node, 1);
		assertEquals(2, found.size);
		assertEquals((Integer) 0, found.left.value);
		assertNull(found.right);

		found = node.find(node, 2);
		assertEquals(5, found.size);
		assertEquals((Integer) 3, found.right.value);
		assertEquals((Integer) 1, found.left.value);

		found = node.find(node, 0);
		assertEquals(1, found.size);
		assertEquals(null, found.left);
		assertNull(found.right);
	}

	@Test
	public void getRandomNodeTest() {

		node = new RNode();
		RNode node2 = new RNode();
		node2.insertInOrder(node, 2);
		node2.insertInOrder(node, 1);
		node2.insertInOrder(node, 3);
		node2.insertInOrder(node, 0);
		node2.insertInOrder(node, 4);

		for (int i = 0; i < 10; i++) {
//			System.out.println(node.getRandomNode(node).value);
		}

	}

}
