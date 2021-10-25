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

		node.insert(2);
		node.insert(1);
		node.insert(3);
		node.insert(0);
		node.insert(4);
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
		RNode found = node.find(3);
		assertEquals((Integer) 3, found.value);

		found = node.find(0);
		assertEquals((Integer) 0, found.value);

		found = node.find(4);
		assertEquals((Integer) 4, found.value);
	}

	@Test
	public void deleteTest() {
		node.printTree(node);
		RNode found = node.delete(4);
		assertNull(found.right.right);

		found = node.delete(1);
		assertEquals((Integer) 0, found.left.value);
		assertNull(found.left.left);

		found.insert(10);
		found.insert(7);
		found.insert(6);
		found.insert(12);
//		found.printTree(node);
		found = node.delete(10);
		assertEquals((Integer) 7, found.right.right.value);
//		found.printTree(node);

		found = node.delete(2);
		assertEquals((Integer) 0, found.value);
	}

	@Test
	public void insertInOrderTest() {

		node = new RNode(2);
		node.insertInOrder(1);
		node.insertInOrder(3);
		node.insertInOrder(0);
		node.insertInOrder(4);

		RNode found = node.find(3);
		assertEquals(2, found.size);
		assertEquals((Integer) 4, found.right.value);
		assertNull(found.left);

		found = node.find(1);
		assertEquals(2, found.size);
		assertEquals((Integer) 0, found.left.value);
		assertNull(found.right);

		found = node.find(2);
		assertEquals(5, found.size);
		assertEquals((Integer) 3, found.right.value);
		assertEquals((Integer) 1, found.left.value);

		found = node.find(0);
		assertEquals(1, found.size);
		assertEquals(null, found.left);
		assertNull(found.right);
	}

	@Test
	public void getRandomNodeTest() {

		node = new RNode();
		RNode node2 = new RNode();
		node2.insertInOrder(2);
		node2.insertInOrder(1);
		node2.insertInOrder(3);
		node2.insertInOrder(0);
		node2.insertInOrder(4);

		// for (int i = 0; i < 10; i++) {
		System.out.println(node2.getRandomNode().value);
		// }

	}

}
