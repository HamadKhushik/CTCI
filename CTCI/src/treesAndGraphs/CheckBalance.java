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

}
