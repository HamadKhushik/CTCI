package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CheckSubtreeTest {

	BinaryTree<Integer> tree = new BinaryTree<Integer>();
	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
	BinaryTreeNode<Integer> rootSubTree = new BinaryTreeNode<Integer>();
	CheckSubtree check = new CheckSubtree();

	@Before
	public void setUp() throws Exception {

		tree.add(3);
		root = tree.getRoot();
		tree.addLeft(root, 4);
		tree.addRight(root, 5);
		tree.addLeft(root.getLeft(), 1);
		tree.addRight(root.getLeft(), 2);
		tree.printTree(root);

		// subtree
		tree = new BinaryTree<Integer>();
		tree.add(4);
		rootSubTree = tree.getRoot();
		tree.addLeft(rootSubTree, 1);
		tree.addRight(rootSubTree, 2);
		tree.printTree(rootSubTree);
	}

	@Test
	public void checkIfSubtreeest() {
		boolean isSubtree = check.checkIfSubtree(root, rootSubTree);
		assertEquals(true, isSubtree);

		tree.addRight(root.getLeft().getRight(), 0);
//		tree.printTree(root);
		isSubtree = check.checkIfSubtree(root, rootSubTree);
		assertEquals(false, isSubtree);

		// null check
		tree = new BinaryTree<Integer>();
		root = tree.getRoot(); // this will create a new root node with null data
		isSubtree = check.checkIfSubtree(root, rootSubTree);
		assertEquals(false, isSubtree);

		// when both trees are null
		rootSubTree = null;
		System.out.println(root);
		root = null;
		isSubtree = check.checkIfSubtree(root, rootSubTree);
		assertEquals(true, isSubtree);
	}

}
