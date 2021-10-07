package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 4.3 list of Depths
 * create a linked list for every level/depth of a binary tree
 */
public class ListOfDepths {

	public List<List<BinaryTreeNode<Integer>>> listOfLevels(BinaryTreeNode<Integer> root) {

		List<LinkedList<BinaryTreeNode<Integer>>> listOfList = new LinkedList<LinkedList<BinaryTreeNode<Integer>>>();

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();

		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

		}

		return null;
	}

	// Recursive Implementation using dfs
	// Time Complexity O(N)
	// Space complexity O(log N)
	public void listOfLevelsRecursive(BinaryTreeNode<Integer> root, List<LinkedList<BinaryTreeNode<Integer>>> lists,
			int level) {

		// base case
		if (root == null) {
			return;
		}

		LinkedList<BinaryTreeNode<Integer>> list;
		// create list for said level - since it hasnt already been created
		if (lists.size() == level) {
			list = new LinkedList<BinaryTreeNode<Integer>>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);

		listOfLevelsRecursive(root.getLeft(), lists, level + 1);
		listOfLevelsRecursive(root.getRight(), lists, level + 1);

	}

	public List<LinkedList<BinaryTreeNode<Integer>>> listOfBSTLevels(BinaryTreeNode<Integer> root) {

		List<LinkedList<BinaryTreeNode<Integer>>> lists = new ArrayList<LinkedList<BinaryTreeNode<Integer>>>();
		listOfLevelsRecursive(root, lists, 0);

		return lists;
	}

	// iterative solution based on bfs
	// time complexity O(N)
	// space complexity O(1)
	public List<LinkedList<BinaryTreeNode<Integer>>> createLevelLinkedList(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return new LinkedList<LinkedList<BinaryTreeNode<Integer>>>();
		}

		List<LinkedList<BinaryTreeNode<Integer>>> result = new ArrayList<LinkedList<BinaryTreeNode<Integer>>>();
		LinkedList<BinaryTreeNode<Integer>> current = new LinkedList<BinaryTreeNode<Integer>>();

		// add root
		current.add(root);

		while (current.size() != 0) {
			// add previous level
			result.add(current);
			LinkedList<BinaryTreeNode<Integer>> parents = current;
			current = new LinkedList<BinaryTreeNode<Integer>>();

			for (BinaryTreeNode<Integer> parent : parents) {

				if (parent.getLeft() != null) {
					current.add(parent.getLeft());
				}
				if (parent.getRight() != null) {
					current.add(parent.getRight());
				}
			}
		}
		return result;
	}
}
