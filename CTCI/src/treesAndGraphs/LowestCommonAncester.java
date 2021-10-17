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

	/*
	 * Lowest Common Ancester Book Solution similar solution as of intersection of
	 * two linked lists traverse the trees at the same time and return when a common
	 * node is found uses the parent link
	 */

	public BinaryTreeNode<Integer> commonAncester(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> n1,
			BinaryTreeNode<Integer> n2) {

		if (root == null || !covers(root, n1) || !covers(root, n2)) {
			return null;
		}

		// find the difference in height of the trees
		int delta = depth(n1) - depth(n2);
		BinaryTreeNode<Integer> first = delta > 0 ? n2 : n1;
		BinaryTreeNode<Integer> second = delta > 0 ? n1 : n2;
		// bring both tree on the same height
		second = goUpBy(second, Math.abs(delta));

		// find the common ancester
		while (!first.equals(second) && first != null && second != null) {
			first = first.getParent();
			second = second.getParent();
		}

		return first == null || second == null ? null : first;
	}

	// helper method to find the depth of a tree node
	private int depth(BinaryTreeNode<Integer> root) {

		int depth = 0;
		while (root.getParent() != null) {
			root = root.getParent();
			depth++;
		}

		return depth;
	}

	// helper method to go up the nodes on a tree
	public BinaryTreeNode<Integer> goUpBy(BinaryTreeNode<Integer> node, int delta) {

		while (delta > 0) {
			node = node.getParent();
			delta--;
		}

		return node;
	}

}
