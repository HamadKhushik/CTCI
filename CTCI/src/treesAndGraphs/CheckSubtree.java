package treesAndGraphs;

/*
 * 4.10 Check Subtree
 * determine if one tree is subtree of another tree
 *  
 */
public class CheckSubtree {

	/*
	 * solution based on https://www.youtube.com/watch?v=HdMs2Fl_I-Q time omplexity
	 * (m * n) where 'm' is number of nodes in first tree and 'n' is number of nodes
	 * in second tree as we are comparing second tree with every node in first tree
	 */
	public boolean checkIfSubtree(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {

		if (node1 == null || node2 == null) {
			return node1 == null && node2 == null;
		}

		if (sameTree(node1, node2)) {
			return true;
		} else {
			return sameTree(node1.getLeft(), node2) || sameTree(node1.getRight(), node2);
		}
	}

	public boolean sameTree(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {

		if (node1 == null || node2 == null) {
			return (node1 == null) && (node2 == null);
		} else if (!node1.equals(node2)) {
			return false;
		} else {
			return sameTree(node1.getLeft(), node2.getLeft()) && sameTree(node1.getRight(), node2.getRight());
		}
	}

}
