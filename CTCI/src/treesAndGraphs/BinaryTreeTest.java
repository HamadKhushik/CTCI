package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

	BinaryTree<Integer> bt = new BinaryTree<Integer>();
	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();

	@Before
	public void setUp() throws Exception {

		bt = bt.createBinaryTree();
		root = bt.getRoot();
	}

	@Test
	public void add() {
		root = root.getLeft();
		assertEquals(root.getData(), (Integer) 4);

		root = root.getLeft();
		assertEquals(root.getData(), (Integer) 3);

		bt.add(2);
		root = root.getLeft();
		assertEquals(root.getData(), (Integer) 2);

		root = bt.getRoot();
		bt.add(4);
		root = root.getLeft();
		assertEquals(root.getData(), (Integer) 4);
		root = root.getLeft();
		assertEquals(root.getData(), (Integer) 3);

		root = bt.getRoot();
		root = root.getLeft();
		root = root.getRight();
		assertEquals(root.getData(), (Integer) 5);
	}

}
