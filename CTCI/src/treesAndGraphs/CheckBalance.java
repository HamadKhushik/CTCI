package treesAndGraphs;

/*
 * 4.4 Check Balance of a Binary Tree
 * A balanced tree is defined to be a tree such that the 
 * heights of the sub-trees of any Node never differ by 
 * more than 1
 */
public class CheckBalance {

	public int checkHeight(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return -1;
		}

		int leftHeight = checkHeight(root.getLeft());
		int rightHeight = checkHeight(root.getRight());

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public boolean isBalanced(BinaryTreeNode<Integer> root) {

		// base case
		if (root == null) {
			return true;
		}

		int leftHeight = checkHeight(root.getLeft());
		int rightHeight = checkHeight(root.getRight());
		int heightDiff = leftHeight - rightHeight;

		if (Math.abs(heightDiff) > 1) {
			return false;
		}

		return isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}

	// calculates height and checks if tree is balanced
	// return Integer.MIN if not balanced
	public int checkHeightEfficient(BinaryTreeNode<Integer> root) {

		// base case
		if (root == null) {
			return -1;
		}

		int leftHeight = checkHeightEfficient(root.getLeft());
		// pass error up (to the caller)
		if (leftHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		// pass error to the caller
		int rightHeight = checkHeightEfficient(root.getRight());
		if (leftHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		// if unbalanced, return error
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return Integer.MIN_VALUE;
		}

		return Math.max(checkHeightEfficient(root.getLeft()), checkHeightEfficient(root.getRight())) + 1;
	}

	public boolean isBalancedEfficient(BinaryTreeNode<Integer> root) {

		// base case
		if (root == null) {
			return true;
		}

		if (checkHeightEfficient(root) == Integer.MIN_VALUE) {
			return false;
		} else {
			checkHeightEfficient(root.getLeft());
			checkHeightEfficient(root.getRight());
		}

		return true;
	}

}
