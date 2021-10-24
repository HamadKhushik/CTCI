package treesAndGraphs;

/*
 * 4.11 Random Node
 * Implement a Binary Search tree with insert, find and delete methods and 
 * also implement a find random node. All nodes should be equally likely to be chosen
 */
public class RandomNode {

}

class RNode {

	Integer value;
	RNode left;
	RNode right;

	static final int COUNT = 7;

	public RNode(int data) {
		value = data;
		left = null;
		right = null;
	}

	public RNode() {
		value = null;
		left = null;
		right = null;
	}

	public void insert(RNode root, Integer data) {

		if (data == null || root == null) {
			return;
		}

		if (root.value == null) {
			root.value = data;
			return;
		}

		if (data <= root.value && root.left != null) {
			insert(root.left, data);
		} else if (data < root.value && root.left == null) {
			RNode node = new RNode(data);
			root.left = node;
			return;
		}

		if (data > root.value && root.right != null) {
			insert(root.right, data);
		} else if (data > root.value && root.right == null) {
			RNode node = new RNode(data);
			root.right = node;
		}
	}

	// in-order traversal to find the node
	public RNode find(RNode root, int data) {

		if (root == null) {
			return null;
		}

		if (root.value.equals(data)) {
			return root;
		}

		RNode result = null;
		// if node is not found on the left sub-tree, search the node on right sub-tree
		result = find(root.left, data);
		if (result == null) {
			result = find(root.right, data);
		}

		return result;
	}

	// wrapper for print2DTree method
	public void printTree(RNode root) {

		print2DTree(root, 0);

	}

	// helper method to print tree recursively
	public void print2DTree(RNode root, int space) {

		if (root == null) {
			return;
		}

		// distance between levels
		space += COUNT;

		// right child first
		print2DTree(root.right, space);

		System.out.print("\n");
		for (int i = COUNT; i < space; i++) {
			System.out.print(" ");
		}
		System.out.print(root.value + "\n");

		// left child
		print2DTree(root.left, space);
	}
}
