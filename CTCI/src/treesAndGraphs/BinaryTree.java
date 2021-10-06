package treesAndGraphs;

/*
 * implementation of binary tree using recursion 
 */
public class BinaryTree<T extends Comparable<T>> {

	private BinaryTreeNode<T> root;

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
		if (current.getData().compareTo(value) < 0) {
			current.setLeft(addRecursive(current.getLeft(), value));
		}
		// if value is greater than current
		else if (current.getData().compareTo(value) > 0) {
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
}
