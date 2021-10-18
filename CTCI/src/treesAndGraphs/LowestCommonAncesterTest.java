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
		// bt.printTree(bt.getRoot());
	}

	@Test
	public void lcaTest() {
		root = bt.getRoot();
		BinaryTreeNode<Integer> ancester = lca.lca(root, bt.findNode(root, 6), bt.findNode(root, 8));
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

	@Test
	public void commonAncesterTest() {
		root = bt.getRoot();
		// bt.printTree(bt.getRoot());
		BinaryTreeNode<Integer> ancester = lca.commonAncester(root, bt.findNode(root, 6), bt.findNode(root, 8));
		assertEquals(new BinaryTreeNode<Integer>(3), ancester);

		ancester = lca.commonAncester(root, bt.findNode(root, 11), bt.findNode(root, 2));
		assertEquals(new BinaryTreeNode<Integer>(6), ancester);

		ancester = lca.commonAncester(root, bt.findNode(root, 2), bt.findNode(root, 5));
		assertEquals(new BinaryTreeNode<Integer>(6), ancester);

		ancester = lca.commonAncester(root, bt.findNode(root, 8), bt.findNode(root, 7));
		assertEquals(new BinaryTreeNode<Integer>(8), ancester);

		ancester = lca.commonAncester(root, bt.findNode(root, 8), bt.findNode(root, 20));
		assertNull(ancester);

		ancester = lca.commonAncester(root, bt.findNode(root, 20), bt.findNode(root, 13));
		assertNull(ancester);
	}

	@Test
	public void getSiblingTest() {
		root = bt.getRoot();
		// bt.printTree(bt.getRoot());
		BinaryTreeNode<Integer> sibling = lca.getSibling(bt.findNode(root, 6));
		assertEquals(new BinaryTreeNode<Integer>(8), sibling);

		sibling = lca.getSibling(bt.findNode(root, 2));
		assertEquals(new BinaryTreeNode<Integer>(11), sibling);

		sibling = lca.getSibling(bt.findNode(root, 5));
		assertEquals(new BinaryTreeNode<Integer>(9), sibling);

		sibling = lca.getSibling(bt.findNode(root, 7));
		assertEquals(null, sibling);
	}

	@Test
	public void commonAncesterSiblingTest() {
		root = bt.getRoot();
		// bt.printTree(bt.getRoot());
		BinaryTreeNode<Integer> ancester = lca.commonAncesterSibling(root, bt.findNode(root, 6), bt.findNode(root, 8));
		assertEquals(new BinaryTreeNode<Integer>(3), ancester);

		ancester = lca.commonAncesterSibling(root, bt.findNode(root, 11), bt.findNode(root, 2));
		assertEquals(new BinaryTreeNode<Integer>(6), ancester);

		ancester = lca.commonAncesterSibling(root, bt.findNode(root, 2), bt.findNode(root, 5));
		assertEquals(new BinaryTreeNode<Integer>(6), ancester);

		ancester = lca.commonAncesterSibling(root, bt.findNode(root, 8), bt.findNode(root, 7));
		assertEquals(new BinaryTreeNode<Integer>(8), ancester);

		ancester = lca.commonAncesterSibling(root, bt.findNode(root, 8), bt.findNode(root, 20));
		assertNull(ancester);

		ancester = lca.commonAncesterSibling(root, bt.findNode(root, 20), bt.findNode(root, 13));
		assertNull(ancester);
	}

	@Test
	public void commonAncester3Test() {
		root = bt.getRoot();
		// bt.printTree(bt.getRoot());
		BinaryTreeNode<Integer> ancester = lca.commonAncester3(root, bt.findNode(root, 6), bt.findNode(root, 8));
		assertEquals(new BinaryTreeNode<Integer>(3), ancester);

		ancester = lca.commonAncester3(root, bt.findNode(root, 11), bt.findNode(root, 2));
		assertEquals(new BinaryTreeNode<Integer>(6), ancester);

		ancester = lca.commonAncester3(root, bt.findNode(root, 2), bt.findNode(root, 5));
		assertEquals(new BinaryTreeNode<Integer>(6), ancester);

		ancester = lca.commonAncester3(root, bt.findNode(root, 8), bt.findNode(root, 7));
		assertEquals(new BinaryTreeNode<Integer>(8), ancester);

		ancester = lca.commonAncester3(root, bt.findNode(root, 8), bt.findNode(root, 20));
		assertNull(ancester);

		ancester = lca.commonAncester3(root, bt.findNode(root, 20), bt.findNode(root, 13));
		assertNull(ancester);
	}

	@Test
	public void commonAncesterOptimisedTest() {
		root = bt.getRoot();
		bt.printTree(bt.getRoot());
		BinaryTreeNode<Integer> ancester = lca.commonAncesterOptimised(root, bt.findNode(root, 6),
				bt.findNode(root, 8));
		assertEquals(new BinaryTreeNode<Integer>(3), ancester);

		ancester = lca.commonAncesterOptimised(root, bt.findNode(root, 11), bt.findNode(root, 2));
		assertEquals(new BinaryTreeNode<Integer>(6), ancester);

		ancester = lca.commonAncesterOptimised(root, bt.findNode(root, 2), bt.findNode(root, 5));
		assertEquals(new BinaryTreeNode<Integer>(6), ancester);

		ancester = lca.commonAncesterOptimised(root, bt.findNode(root, 8), bt.findNode(root, 7));
		assertEquals(new BinaryTreeNode<Integer>(8), ancester);

		ancester = lca.commonAncesterOptimised(root, bt.findNode(root, 8), bt.findNode(root, 20));
		assertNull(ancester);

		ancester = lca.commonAncesterOptimised(root, bt.findNode(root, 20), bt.findNode(root, 13));
		assertNull(ancester);
	}
}
