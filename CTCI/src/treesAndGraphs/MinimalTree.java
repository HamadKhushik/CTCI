package treesAndGraphs;

/*
 * 4.2 Minimal Tree
 * given a sorted array, create a binary search tree
 * recursive solution
 */
public class MinimalTree {

	public BinaryTree<Integer> bstFromSortedArray(int[] array) {

		if (array.length == 0) {
			return null;
		}
		// need a binary tree to return a binary tree
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		bt.setRoot(constructTreeFromArray(array, 0, array.length - 1));

		return bt;
	}

	public BinaryTreeNode<Integer> constructTreeFromArray(int[] array, int left, int right) {

		if (left > right) {
			return null;
		}

		int midpoint = left + (right - left) / 2;
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(array[midpoint]);
		node.setLeft(constructTreeFromArray(array, left, midpoint - 1));
		node.setRight(constructTreeFromArray(array, midpoint + 1, right));

		return node;
	}
}
