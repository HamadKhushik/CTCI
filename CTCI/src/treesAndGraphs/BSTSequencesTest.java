package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BSTSequencesTest {

	BinaryTree<Integer> tree = new BinaryTree<Integer>();
	BinaryTreeNode<Integer> root;

	BSTSequences sequences = new BSTSequences();
	List<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

	@Before
	public void setUp() throws Exception {

		tree.add(10);
		tree.add(5);
		tree.add(20);
		tree.add(2);
		tree.add(30);
		root = tree.getRoot();
		tree.printTree(root);
	}

	@Test
	public void findSequencesTest() {
		result = sequences.findSequences(root);
//		sequences.printLists(result);
		assertEquals(6, result.size());

		tree = new BinaryTree<Integer>();
		tree.add(10);
		tree.add(5);
		tree.add(20);
		result = sequences.findSequences(tree.getRoot());
//		sequences.printLists(result);
		assertEquals(2, result.size());

		tree = new BinaryTree<Integer>();
		tree.add(10);
		tree.add(5);
		tree.add(20);
		tree.add(2);
		tree.add(4);
		tree.add(30);
		result = sequences.findSequences(tree.getRoot());
//		sequences.printLists(result);
		assertEquals(10, result.size());

		// null node check
		tree = new BinaryTree<Integer>();
		result = sequences.findSequences(tree.getRoot());
		assertEquals(1, result.size());
	}

}
