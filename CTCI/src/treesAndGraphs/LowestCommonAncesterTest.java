package treesAndGraphs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class LowestCommonAncesterTest {

	LowestCommonAncester lca = new LowestCommonAncester();
	BinaryTree<Integer> bt = new BinaryTree<Integer>(3);
	BinaryTreeNode<Integer> root = bt.getRoot();

	@Before
	public void setUp() throws Exception {

		bt.addLeft(root, 6);
		bt.addRight(root, 8);
		root = root.getLeft();
		bt.addLeft(root, 2);
		bt.addRight(root, 11);
		root = root.getRight();
		bt.addLeft(root, 9);
		bt.addRight(root, 5);
		root = bt.getRoot();
		root = root.getRight();
		bt.addRight(root, 13);
		root = root.getRight();
		bt.addLeft(root, 7);
		bt.printTree(bt.getRoot());
	}

	@Test
	public void lcaTest() {
		root = bt.getRoot();
		BinaryTreeNode<Integer> ancester = lca.lca(root, new BinaryTreeNode<Integer>(6),
				new BinaryTreeNode<Integer>(8));
		assertEquals(new BinaryTreeNode<Integer>(3), ancester);

		ancester = lca.lca(root, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(11));
		assertEquals(new BinaryTreeNode<Integer>(6), ancester);

		ancester = lca.lca(root, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(5));
		assertEquals(new BinaryTreeNode<Integer>(6), ancester);

		ancester = lca.lca(root, new BinaryTreeNode<Integer>(8), new BinaryTreeNode<Integer>(7));
		assertEquals(new BinaryTreeNode<Integer>(8), ancester);

		ancester = lca.lca(root, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(20));
		assertNull(ancester);

		ancester = lca.lca(root, new BinaryTreeNode<Integer>(20), new BinaryTreeNode<Integer>(13));
		assertNull(ancester);
	}

}
