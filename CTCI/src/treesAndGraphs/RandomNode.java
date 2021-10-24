package treesAndGraphs;

import java.util.Random;

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
	int size;

	static final int COUNT = 7;

	public RNode(int data) {
		value = data;
		left = null;
		right = null;
		size = 1;
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
		} else if (data < root.value) {
			return root.left != null ? find(root.left, data) : null;
		} else if (data > root.value) {
			return root.right != null ? find(root.right, data) : null;
		}

		return null;
	}

	/*
	 * delete a node three cases to be considered when deleting a node case-1 if
	 * node to be deleted has no child case-2 if node to be deleted has only one
	 * child case-3 if node to be deleted has two children Ref:
	 * https://www.youtube.com/watch?v=5_AZcOOc-kM
	 */
	public RNode delete(RNode node, int data) {

		if (node == null) {
			return null;
		}

		// if data is greater than node.value -> go to right subtree
		if (data > node.value) {
			node.right = delete(node.right, data);
		}
		// if data is less than node.value -> go to left subtree
		else if (data < node.value) {
			node.left = delete(node.left, data);
		}
		// if data is equal to node.value -> there are three cases to be considered
		else {

			// if node has two children
			if (node.left != null && node.right != null) {
				int max = max(node.left); // find max in left sub-tree
				node.value = max;
				node.left = delete(node.left, max); // delete max in left subtree
				return node;
			}
			// if node has only one child -> return the non null child
			if (node.left != null && node.right == null) {
				return node.left;
			} else if (node.right != null && node.left == null) {
				return node.right;
			}
			// if node has no children -> return null;
			else {
				return null;
			}
		}
		// if node to be deleted is not in the tree
		return node;
	}

	// helper method to find the max node in tree
	public int max(RNode node) {

		if (node.right != null) {
			return max(node.right);
		}
		// if node.right == null, then 'node' must be maximum node in the tree
		else {
			return node.value;
		}
	}

	// wrapper for print2DTree method
	public void printTree(RNode root) {

		print2DTree(root, 0);

	}

	/*
	 * *****************************Book Solution*********************************
	 * insertInOrder updates the size of each subtree upon inserting a node
	 */
	public void insertInOrder(RNode root, int data) {

		if (root == null) {
			return;
		} else if (root.value == null) {
			root.value = data;
			return;
		}

		if (data <= root.value) {
			if (root.left == null) {
				root.left = new RNode(data);
			} else {
				insertInOrder(root.left, data);
			}
		} else {
			if (root.right == null) {
				root.right = new RNode(data);
			} else {
				insertInOrder(root.right, data);
			}
		}
		root.size++;
	}

	/*
	 * get and returns a random node. every node has equal probability each node in
	 * the tree has 1/n probability where 'n' is the number of nodes in the tree
	 */
	public RNode getRandomNode(RNode root) {

		int leftSize = root.left == null ? 0 : root.left.size;
		Random random = new Random();
		int index = random.nextInt(root.size);

		if (index < leftSize) {
			return getRandomNode(root.left);
		} else if (index == leftSize) {
			return root;
		} else {
			return getRandomNode(root.right);
		}
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
