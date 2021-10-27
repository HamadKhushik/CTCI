package treesAndGraphs;

import java.util.HashMap;

/*
 * 4.12 Path Sum
 * return the number of paths that sum to a target value in a Binary Tree
 */

public class PathSum {

	// time complexity O(n log n) in a balanced tree and O(n2) in an unbalanced
	// Binary Tree
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

	/*
	 * optimised method to find the pathSum. time complexity O(n) as we traverse
	 * each node only once. space complexity O(log n) in a balanced Binary Tree as
	 * we use hashmap
	 */
	public int countSumOptimised(BinaryTreeNode<Integer> root, int target) {

		return countSumOptimisedHelper(root, target, 0, new HashMap<Integer, Integer>());

	}

	public int countSumOptimisedHelper(BinaryTreeNode<Integer> root, int target, int currSum,
			HashMap<Integer, Integer> map) {

		if (root == null) {
			return 0;
		}

		currSum += root.getData();
		int sum = currSum - target;
		int paths = map.getOrDefault(sum, 0);

		if (currSum == target) {
			paths++;
		}

		incrementHashMap(map, currSum, 1);
		paths += countSumOptimisedHelper(root.getLeft(), target, currSum, map);
		paths += countSumOptimisedHelper(root.getRight(), target, currSum, map);
		incrementHashMap(map, currSum, -1);

		return paths;
	}

	public void incrementHashMap(HashMap<Integer, Integer> map, int key, int value) {

		int total = map.getOrDefault(key, 0) + value;

		if (total == 0) {
			map.remove(key);
		} else {
			map.put(key, total);
		}
	}
}
