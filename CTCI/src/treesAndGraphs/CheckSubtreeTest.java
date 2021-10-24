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
//		tree.printTree(root);

		// subtree
		tree = new BinaryTree<Integer>();
		tree.add(4);
		rootSubTree = tree.getRoot();
		tree.addLeft(rootSubTree, 1);
		tree.addRight(rootSubTree, 2);
//		tree.printTree(rootSubTree);
	}

	@Test
	public void checkIfSubtreeTest() {
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
		isSubtree = check.checkIfSubtree(null, null);
		assertEquals(false, isSubtree);

		isSubtree = check.checkIfSubtree(root, null);
		assertEquals(true, isSubtree);
	}

	@Test
	public void preOrderTraversalTest() {

		BinaryTree<String> stringTree = new BinaryTree<String>();
		BinaryTree<String> stringSubtree = new BinaryTree<String>();

		createTrees(stringTree, stringSubtree);
		StringBuilder string1 = new StringBuilder();

		check.preOrderTraversal(stringTree.getRoot(), string1);
		assertEquals("3, 4, 1, X, X, 2, X, X, 5, X, X, ", string1.toString());

		string1 = new StringBuilder();
		check.preOrderTraversal(stringSubtree.getRoot(), string1);
		assertEquals("4, 1, X, X, 2, X, X, ", string1.toString());
	}

	@Test
	public void containsTreeTest() {

		BinaryTree<String> stringTree = new BinaryTree<String>();
		BinaryTree<String> stringSubtree = new BinaryTree<String>();

		createTrees(stringTree, stringSubtree);

		boolean isSubtree = check.containsTree(stringTree.getRoot(), stringSubtree.getRoot());
		assertEquals(true, isSubtree);

		stringTree.addRight(stringTree.getRoot().getLeft().getRight(), "0");
		isSubtree = check.containsTree(stringTree.getRoot(), stringSubtree.getRoot());
		assertEquals(false, isSubtree);

		// null check
		isSubtree = check.containsTree(null, stringSubtree.getRoot());
		assertEquals(false, isSubtree);

		// when both trees are null
		isSubtree = check.containsTree(null, null);
		assertEquals(true, isSubtree);
	}

	@Test
	public void containsTreeRecursiveTest() {

		BinaryTree<String> stringTree = new BinaryTree<String>();
		BinaryTree<String> stringSubtree = new BinaryTree<String>();

		createTrees(stringTree, stringSubtree);

		boolean isSubtree = check.containsTreeRecursive(stringTree.getRoot(), stringSubtree.getRoot());
		assertEquals(true, isSubtree);

		stringTree.addRight(stringTree.getRoot().getLeft().getRight(), "0");
		isSubtree = check.containsTreeRecursive(stringTree.getRoot(), stringSubtree.getRoot());
		assertEquals(false, isSubtree);

		// null check
		isSubtree = check.containsTreeRecursive(null, stringSubtree.getRoot());
		assertEquals(false, isSubtree);

		// when both trees are null
		isSubtree = check.containsTreeRecursive(null, null);
		assertEquals(false, isSubtree);
	}

	public void createTrees(BinaryTree<String> tree1, BinaryTree<String> tree2) {

		tree1.add("3");
		BinaryTreeNode<String> stringRoot = tree1.getRoot();
		tree1.addLeft(stringRoot, "4");
		tree1.addRight(stringRoot, "5");
		tree1.addLeft(stringRoot.getLeft(), "1");
		tree1.addRight(stringRoot.getLeft(), "2");
//		stringTree.printTree(stringRoot);

		// subtree
		tree2.add("4");
		stringRoot = tree2.getRoot();
		tree2.addLeft(stringRoot, "1");
		tree2.addRight(stringRoot, "2");

	}

}
