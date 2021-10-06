package treesAndGraphs;

/*
 * implementation of Binary Tree Node 
 */
public class BinaryTreeNode<T extends Comparable<T>> {

	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {

		this.data = data;
		left = null;
		right = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

}
