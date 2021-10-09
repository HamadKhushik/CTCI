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
		bt.printTree(root);
	}

	@Test
	public void add() {

		assertEquals(root.getData(), (Integer) 6);
		assertEquals(null, root.getParent());

		root = root.getLeft();
		assertEquals((Integer) 4, root.getData());
		assertEquals((Integer) 6, root.getParent().getData());

		root = root.getLeft();
		assertEquals((Integer) 3, root.getData());
		assertEquals((Integer) 4, root.getParent().getData());

		bt.add(2);
		root = root.getLeft();
		assertEquals((Integer) 2, root.getData());
		assertEquals((Integer) 3, root.getParent().getData());

		root = bt.getRoot();
		bt.add(4);
		root = root.getLeft();
		assertEquals((Integer) 4, root.getData());
		assertEquals((Integer) 6, root.getParent().getData());
		root = root.getLeft();
		assertEquals((Integer) 3, root.getData());
		assertEquals((Integer) 4, root.getParent().getData());

		root = bt.getRoot();
		root = root.getLeft();
		root = root.getRight();
		assertEquals((Integer) 5, root.getData());
		assertEquals((Integer) 4, root.getParent().getData());
	}

}
