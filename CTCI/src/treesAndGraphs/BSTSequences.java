package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 4.9 BST Sequences
 * This method returns all the sequence of lists which results in the same binary search tree
 * This is the book solution and uses two recursive algorithms
 * REF : https://medium.com/@jackwootton/binary-search-tree-sequences-53163b1f374a
 */
public class BSTSequences {

	public List<LinkedList<Integer>> findSequences(BinaryTreeNode<Integer> node) {

		List<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();

		// Base case
		if (node == null) {
			results.add(new LinkedList<Integer>());
			return results;
		}

		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.getData());

		// recurse
		List<LinkedList<Integer>> leftTree = findSequences(node.getLeft());
		List<LinkedList<Integer>> rightTree = findSequences(node.getRight());

		for (LinkedList<Integer> first : leftTree) {
			for (LinkedList<Integer> second : rightTree) {
				List<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(first, second, weaved, prefix);
				results.addAll(weaved);
			}
		}
		return results;
	}

	// second recursive function to combine the lists
	private void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, List<LinkedList<Integer>> results,
			LinkedList<Integer> prefix) {

		// base case
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		// recurse with head of first list
		Integer firstHead = first.removeFirst();
		prefix.add(firstHead);
		weaveLists(first, second, results, prefix);
		firstHead = prefix.removeLast();
		first.addFirst(firstHead);

		// recurse with head of second list
		Integer secondHead = second.removeFirst();
		prefix.add(secondHead);
		weaveLists(first, second, results, prefix);
		secondHead = prefix.removeLast();
		second.addFirst(secondHead);
	}

	// helper method to print results
	public void printLists(List<LinkedList<Integer>> results) {

		for (LinkedList<Integer> list : results) {
			System.out.println(list);
		}
	}

}
