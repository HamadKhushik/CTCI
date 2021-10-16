package treesAndGraphs;

/*
 * 4. 8 find the lowest common ancestor in 'Binary Tree'
 * 
 */
public class LowestCommonAncester {

	/*
	 * return null if none of the nodes is found recurse the tree, return the node
	 * if one of the nodes is found return root if both the nodes are found - ->
	 * returns common ancester if exists -> returns one of the node if the second
	 * node 'Tushar Roy solution'
	 * 
	 */
	public BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> n1,
			BinaryTreeNode<Integer> n2) {

		// check if both nodes are in the tree
		if (root == null || !covers(root, n1) || !covers(root, n2)) {
			return null;
		}

		return lcaUtil(root, n1, n2);
	}

	// helper mehtod for the lca
	private BinaryTreeNode<Integer> lcaUtil(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> n1,
			BinaryTreeNode<Integer> n2) {

		if (root == null) {
			return null;
		}

		if (root.equals(n1) || root.equals(n2)) {
			return root;
		}

		BinaryTreeNode<Integer> left = lcaUtil(root.getLeft(), n1, n2);
		BinaryTreeNode<Integer> right = lcaUtil(root.getRight(), n1, n2);

		// if both nodes found return root
		if (left != null && right != null) {
			return root;
		}

		// if none node found return null
		if (left == null && right == null) {
			return null;
		}

		BinaryTreeNode<Integer> result = left != null ? left : right;

		// if one of the nodes found - return that!!
		return left != null ? left : right;
	}

	// helper method to search for a node in a tree
	public boolean covers(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {

		if (root == null) {
			return false;
		}

		if (root.equals(node)) {
			return true;
		}

		return covers(root.getLeft(), node) || covers(root.getRight(), node);
	}

}
