package treesAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * implementation of binary tree using recursion 
 */
public class BinaryTree<T extends Comparable<T>> {

	private BinaryTreeNode<T> root;

	// constant used for spacing to print tree
	static final int COUNT = 10;

	public BinaryTree(T value) {

		root = new BinaryTreeNode<T>(value);
	}

	public BinaryTree() {

		root = new BinaryTreeNode<T>();
	}

//	// constructor overload
//	public BinaryTree(BinaryTreeNode<T> node) {
//		root = node;
//	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	// adds a node to tree recursively
	private BinaryTreeNode<T> addRecursive(BinaryTreeNode<T> current, T value) {

		// if current == null, means we have reached leaf node
		if (current == null || current.getData() == null) {
			return new BinaryTreeNode<T>(value);
		}

		// if value is smaller than current, recurse down the left subtree
		if (value.compareTo(current.getData()) < 0) {
			BinaryTreeNode<T> leftChild = addRecursive(current.getLeft(), value);
			current.setLeft(leftChild);

			// set current Node as parent to leftChild
			leftChild.setParent(current);
		}
		// if value is greater than current
		else if (value.compareTo(current.getData()) > 0) {
			BinaryTreeNode<T> rightChild = addRecursive(current.getRight(), value);
			current.setRight(rightChild);

			// set current Node as parent to leftChild
			rightChild.setParent(current);
		}
		// node/value already exists
		else {
			return current;
		}

		return current;
	}

	// method to start recursion from root node
	public void add(T value) {

		root = addRecursive(root, value);
	}

	// add nodes on the left
	public void addLeft(BinaryTreeNode<T> node, T value) {

		if (covers(node, value)) {
			return;
		}

		BinaryTreeNode<T> btn = new BinaryTreeNode<T>(value);
		btn.setParent(node);
		node.setLeft(btn);
	}

	// add nodes on the right
	public void addRight(BinaryTreeNode<T> node, T value) {

		if (covers(node, value)) {
			return;
		}

		BinaryTreeNode<T> btn = new BinaryTreeNode<T>(value);
		btn.setParent(node);
		node.setRight(btn);
	}

	// checks if a node exists in a tree
	public boolean covers(BinaryTreeNode<T> root, T value) {

		if (root == null) {
			return false;
		}

		if (root.getData() == value)
			return true;

		return covers(root.getLeft(), value) || covers(root.getRight(), value);
	}

	public BinaryTreeNode<T> findNode(BinaryTreeNode<T> root, T value) {

		if (root == null) {
			return null;
		}

		if (root.getData().equals(value)) {
			return root;
		} else {
			BinaryTreeNode<T> foundNode = findNode(root.getLeft(), value);
			if (foundNode == null) {
				foundNode = findNode(root.getRight(), value);
			}
			return foundNode;
		}
	}

	// pre-order traversal
	public void preOrder(BinaryTreeNode<T> node) {

		if (node == null) {
			return;
		}

		// visit root
		System.out.print(node.getData() + " ");
		System.out.println("parent" + node.getParent());

		// left subtree
		preOrder(node.getLeft());

		// right subtree
		preOrder(node.getRight());

	}

	// in-order tree traversal
	public void inOrder(BinaryTreeNode<T> node) {

		if (node == null) {
			return;
		}

		// visit left subtree
		inOrder(node.getLeft());

		// visit root
		System.out.print(node.getData() + " ");

		// visit right sub-tree
		inOrder(node.getRight());
	}

	// post-order traversal
	public void postOrder(BinaryTreeNode<T> node) {

		if (node == null) {
			return;
		}

		// visit left subtree
		postOrder(node.getLeft());

		// visit right subtree
		postOrder(node.getRight());

		// visit root
		System.out.print(node.getData() + " ");
	}

	// level order traversal
	public void levelOrder(BinaryTreeNode<T> node) {

		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		HashSet<BinaryTreeNode<T>> visited = new HashSet<BinaryTreeNode<T>>();

		queue.add(node);

		while (!queue.isEmpty()) {

			BinaryTreeNode<T> curr = queue.remove();

			if (!visited.contains(curr)) {
				if (curr.getLeft() != null) {
					queue.add(curr.getLeft());
				}
				if (curr.getRight() != null) {
					queue.add(curr.getRight());
				}
				visited.add(curr);
				System.out.print(curr.getData() + " ");
			}
		}
	}

	// creates a Binary Tree
	public BinaryTree<Integer> createBinaryTree() {

		BinaryTree<Integer> bt = new BinaryTree<Integer>(6);

		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);

		return bt;
	}

	// wrapper for print2DTree method
	public void printTree(BinaryTreeNode<T> root) {

		print2DTree(root, 0);

	}

	// helper method to print tree recursively
	public void print2DTree(BinaryTreeNode<T> root, int space) {

		if (root == null) {
			return;
		}

		// distance between levels
		space += COUNT;

		// right child first
		print2DTree(root.getRight(), space);

		System.out.print("\n");
		for (int i = COUNT; i < space; i++) {
			System.out.print(" ");
		}
		System.out.print(root.getData() + "\n");

		// left child
		print2DTree(root.getLeft(), space);
	}
}
