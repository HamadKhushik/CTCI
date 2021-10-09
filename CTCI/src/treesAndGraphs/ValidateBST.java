package treesAndGraphs;

/*
 * 4.5 Validate if a Binary Tree is Binary Search Tree
 * Time Complexity O(N)
 */
public class ValidateBST {

	// used in isBST2() method
	private Integer lastPrinted = null;

	// recursive method, time complexity O(N)
	// Tushar Roy - Coding Made Simple (Youtube)
	public boolean checkBST(BinaryTreeNode<Integer> root, int min, int max) {

		// base case
		if (root == null) {
			return true;
		}

		if (root.getData() <= min || root.getData() >= max) {
			return false;
		}

		return checkBST(root.getLeft(), min, root.getData()) && checkBST(root.getRight(), root.getData(), max);
	}

	public boolean isBST(BinaryTreeNode<Integer> root) {

		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// in-order traversal based solution
	public boolean isBST2(BinaryTreeNode<Integer> root) {

		// base case
		if (root == null) {
			return true;
		}

		// traverse left
		if (!isBST2(root.getLeft())) {
			return false;
		}

		// check current
		if (lastPrinted != null && root.getData() <= lastPrinted) {
			return false;
		}

		lastPrinted = root.getData();

		// traverse right
		if (!isBST2(root.getRight())) {
			return false;
		}
		return true;
	}
}
