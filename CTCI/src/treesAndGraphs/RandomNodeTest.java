package treesAndGraphs;

import static org.junit.Assert.assertEquals;

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

}
