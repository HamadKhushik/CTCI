package treesAndGraphs;

/*
 * 4.12 Path Sum
 * return the number of paths that sum to a target value in a Binary Tree
 */

public class PathSum {

	// time complexity O(n2)
	public int countPathsWithSum(BinaryTreeNode<Integer> root, int target) {

		if (root == null) {
			return 0;
		}

		int pathsFromRoot = pathsFromNode(root, target, 0);
		int pathsFromleft = countPathsWithSum(root.getLeft(), target);
		int pathsFromright = countPathsWithSum(root.getRight(), target);

		return pathsFromRoot + pathsFromleft + pathsFromright;
	}

	public int pathsFromNode(BinaryTreeNode<Integer> root, int target, int currSum) {

		if (root == null) {
			return 0;
		}

		int count = 0;
		currSum += root.getData();
		if (currSum == target) {
			count++;
		}

		count += pathsFromNode(root.getLeft(), target, currSum);
		count += pathsFromNode(root.getRight(), target, currSum);

		return count;
	}

}
