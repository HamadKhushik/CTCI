package treesAndGraphs;

/*
 * 4.5 Find the successor Node in BST
 */
public class SuccessorNodeBST {

	/*
	 * method to find the successor Node, taking advantage of the link to parent
	 * Node
	 * 
	 * Time Complexity O(N), where N is the number of Nodes in tree
	 */
	public BinaryTreeNode<Integer> findSuccessorNode(BinaryTreeNode<Integer> node) {

		if (node == null) {
			return null;
		}

		BinaryTreeNode<Integer> currParent = null;

		/*
		 * case-1: if node has a right sub-tree, return left most(smallest) node
		 */
		if (node.getRight() != null) {
			return minNode(node.getRight());
		}

		/*
		 * case-2 & case-3: if node has no right sub-tree case 2-> if the node is left
		 * child - return child.parent case 3-> if the node is right child - go up the
		 * tree until on left side of parent node and return parent
		 */
		else {

			currParent = node.getParent();

			// go up the tree until we are on the left instead of right
			while (currParent != null && currParent.getLeft() != node) {
				node = currParent;
				currParent = currParent.getParent();
			}
		}
		return currParent;
	}

	private BinaryTreeNode<Integer> minNode(BinaryTreeNode<Integer> node) {

		if (node == null) {
			return null;
		}

		// get the left most node
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	/*
	 * finds the successor to a node without using the reference to parent node
	 * takes two arguments i-e root and node to find the successor of
	 */
	public BinaryTreeNode<Integer> findSuccessorToNode(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {

		if (root == null || node == null) {
			return null;
		}

		BinaryTreeNode<Integer> curr = root;
		BinaryTreeNode<Integer> pre = null;

		while (curr != null) {
			//
			if (curr.getData() > node.getData()) {
				pre = curr;
				curr = curr.getLeft();
			} else {
				curr = curr.getRight();
			}
		}

		return pre;
	}
}
