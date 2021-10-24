package treesAndGraphs;

/*
 * 4.10 Check Subtree
 * determine if one tree is subtree of another tree
 *  
 */
public class CheckSubtree {

	/*
	 * solution based on https://www.youtube.com/watch?v=HdMs2Fl_I-Q. time
	 * complexity (m * n) where 'm' is number of nodes in first tree and 'n' is
	 * number of nodes in second tree as we are comparing second tree with every
	 * node in first tree space complexity will be minimum of O(m)/O(n) thats how
	 * deep will the recursion go!
	 */
	public boolean checkIfSubtree(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {

		if (node1 == null) {
			return false;
		} else if (node2 == null) { // null tree is a subtree of every tree
			return true;
		}

		if (sameTree(node1, node2)) {
			return true;
		} else {
			return checkIfSubtree(node1.getLeft(), node2) || checkIfSubtree(node1.getRight(), node2);
		}
	}

	public boolean sameTree(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {

		if (node1 == null || node2 == null) {
			return (node1 == null) && (node2 == null);
		} else if (node1.equals(node2)) {
			return sameTree(node1.getLeft(), node2.getLeft()) && sameTree(node1.getRight(), node2.getRight());
		} else {
			return false;
		}
	}

	/*
	 * non recursive solution using pre-order traversal * two trees are identical if
	 * they have same pre-order traversal the idea is to represent every null node
	 * with an 'x'
	 * 
	 * compare the traversals of both trees and return true if one is substring of
	 * another
	 * 
	 * time complexity O(m*n) where 'm' and 'n' are the number of nodes in trees
	 * (because of java's indexOf method) space complexity O(m + n)
	 */
	public boolean containsTree(BinaryTreeNode<String> node1, BinaryTreeNode<String> node2) {

		StringBuilder string1 = new StringBuilder();
		StringBuilder string2 = new StringBuilder();

		preOrderTraversal(node1, string1);
		preOrderTraversal(node2, string2);

		return string1.indexOf(string2.toString()) != -1;
	}

	// helper method for ontainsTree
	public void preOrderTraversal(BinaryTreeNode<String> node, StringBuilder sb) {

		if (node == null) {
			sb.append("X, ");
			return;
		}

		sb.append(node.getData() + ", ");
		preOrderTraversal(node.getLeft(), sb);
		preOrderTraversal(node.getRight(), sb);
	}

	/*
	 * solution in the book based on recursion time complexity O(m + kn) where 'k'
	 * is number of occurrences of node2's root in node1. 'm' and 'n' are the number
	 * of nodes in node1 and node2. space complexity O(log(node1) + log(node2)) if
	 * trees are balanced otherwise O(m + n)
	 */

	public boolean containsTreeRecursive(BinaryTreeNode<String> node1, BinaryTreeNode<String> node2) {

		if (node1 == null) {
			return false;
		} else if (node2 == null) { // null tree is subtree of every tree
			return true;
		}

		return sameRoots(node1, node2);
	}

	/*
	 * this method checks if the roots are equal - if not, recurse down the tree
	 */
	public boolean sameRoots(BinaryTreeNode<String> node1, BinaryTreeNode<String> node2) {

		if (node1 == null) {
			return false;
		} else if (node1.equals(node2) && matchTree(node1, node2)) {
			return true;
		}

		return sameRoots(node1.getLeft(), node2) || sameRoots(node1.getRight(), node2);
	}

	/*
	 * method to check if the two subtrees are equal -> if one of the nodes is null,
	 * return false -> if both nodes are null, return true -> if both nodes are
	 * equal, recurse and check if every node is equal -> else return false (nodes
	 * must not be equal)
	 */
	public boolean matchTree(BinaryTreeNode<String> node1, BinaryTreeNode<String> node2) {

		if (node1 == null || node2 == null) {
			return node1 == null && node2 == null;
		} else if (node1.equals(node2)) {
			return matchTree(node1.getLeft(), node2.getLeft()) && matchTree(node1.getRight(), node2.getRight());
		} else {
			return false;
		}
	}
}
