package treesAndGraphs;

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

	// adds a node to tree recursively
	private BinaryTreeNode<T> addRecursive(BinaryTreeNode<T> current, T value) {

		// if current == null, means we have reached leaf node
		if (current == null) {
			return new BinaryTreeNode<T>(value);
		}

		// if value is smaller than current
		if (current.getData().compareTo(value) > 0) {
			current.setLeft(addRecursive(current.getLeft(), value));
		}
		// if value is greater than current
		else if (current.getData().compareTo(value) < 0) {
			current.setRight(addRecursive(current.getRight(), value));
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

	public static void main(String[] args) {

		BinaryTree<Integer> bt = new BinaryTree<Integer>(null);
		bt = bt.createBinaryTree();

		bt.printTree(bt.root);
	}
}
