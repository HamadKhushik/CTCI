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

	public void insert(Integer data) {

		if (data == null || this == null) {
			return;
		}

		if (this.value == null) {
			this.value = data;
			return;
		}

		if (data <= this.value && this.left != null) {
			this.left.insert(data);
		} else if (data < this.value && this.left == null) {
			RNode node = new RNode(data);
			this.left = node;
			return;
		}

		if (data > this.value && this.right != null) {
			this.right.insert(data);
		} else if (data > this.value && this.right == null) {
			RNode node = new RNode(data);
			this.right = node;
		}
	}

	// in-order traversal to find the node
	public RNode find(int data) {

		if (this.value.equals(data)) {
			return this;
		} else if (data < this.value) {
			return this.left != null ? this.left.find(data) : null;
		} else if (data > this.value) {
			return this.right != null ? this.right.find(data) : null;
		}

		return null;
	}

	/*
	 * delete a node three cases to be considered when deleting a node case-1 if
	 * node to be deleted has no child case-2 if node to be deleted has only one
	 * child case-3 if node to be deleted has two children Ref:
	 * https://www.youtube.com/watch?v=5_AZcOOc-kM
	 */
	public RNode delete(int data) {

		// if data is greater than node.value -> go to right subtree
		if (data > this.value) {
			this.right = this.right.delete(data);
		}
		// if data is less than node.value -> go to left subtree
		else if (data < this.value) {
			this.left = this.left.delete(data);
		}
		// if data is equal to node.value -> there are three cases to be considered
		else {

			// if node has two children
			if (this.left != null && this.right != null) {
				int max = max(this.left); // find max in left sub-tree
				this.value = max;
				this.left = this.left.delete(max); // delete max in left subtree
				return this;
			}
			// if node has only one child -> return the non null child
			if (this.left != null && this.right == null) {
				return this.left;
			} else if (this.right != null && this.left == null) {
				return this.right;
			}
			// if node has no children -> return null;
			else {
				return null;
			}
		}
		// if node to be deleted is not in the tree
		return this;
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

	/*
	 * *****************************Book Solution*********************************
	 * insertInOrder updates the size of each subtree upon inserting a node
	 */
	public void insertInOrder(int data) {

		if (this.value == null) {
			this.value = data;
			return;
		}

		if (data <= this.value) {
			if (this.left == null) {
				this.left = new RNode(data);
			} else {
				this.left.insertInOrder(data);
			}
		} else {
			if (this.right == null) {
				this.right = new RNode(data);
			} else {
				this.right.insertInOrder(data);
			}
		}
		this.size++;
	}

	/*
	 * get and returns a random node. every node has equal probability each node in
	 * the tree has 1/n probability where 'n' is the number of nodes in the tree
	 */
	public RNode getRandomNode() {

		int leftSize = this.left == null ? 0 : this.left.size;
		Random random = new Random();
		int index = random.nextInt(this.size);

		if (index < leftSize) {
			return this.left.getRandomNode();
		} else if (index == leftSize) {
			return this;
		} else {
			return this.right.getRandomNode();
		}
	}

	// get randmNode() with onl one call to random.nextInt()
	public RNode randomNodeOptimised() {

		int index = new Random().nextInt(this.size + 1);

		return getIthNode(index);
	}

	// returns the ith node in a Binary Tree
	public RNode getIthNode(int i) {

		int leftSize = this.left == null ? 0 : this.left.size;

		if (i < leftSize) {
			return this.left.getIthNode(i);
		} else if (i == leftSize) {
			return this;
		} else {
			return this.right.getIthNode(i - (leftSize + 1)); // because we are skipping leftSize + 1(root) nodes while
																// traversing right
		}
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
