package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListOfDepthsTest {

	BinaryTreeNode<Integer> btn = new BinaryTreeNode<Integer>();
	BinaryTree<Integer> bt = new BinaryTree<Integer>();
	List<LinkedList<BinaryTreeNode<Integer>>> result = new ArrayList<LinkedList<BinaryTreeNode<Integer>>>();
	ListOfDepths lod = new ListOfDepths();

	@Before
	public void setUp() throws Exception {
		bt = bt.createBinaryTree();
		btn = bt.getRoot();
		result = lod.listOfBSTLevels(btn);
	}

	@Test
	public void listOfBSTLevelsTest() {

		// level 0 / root
		assertEquals(result.get(0).get(0).getData(), (Integer) 6);
		// level 1
		assertEquals(result.get(1).get(0).getData(), (Integer) 4);
		assertEquals(result.get(1).get(1).getData(), (Integer) 8);

		// level 2
		assertEquals(result.get(2).get(0).getData(), (Integer) 3);
		assertEquals(result.get(2).get(1).getData(), (Integer) 5);
		assertEquals(result.get(2).get(2).getData(), (Integer) 7);
		assertEquals(result.get(2).get(3).getData(), (Integer) 9);
	}

	@Test
	public void createLevelLinkedListTest() {

		result = lod.createLevelLinkedList(btn);

		// level 0 / root
		assertEquals(result.get(0).get(0).getData(), (Integer) 6);
		// level 1
		assertEquals(result.get(1).get(0).getData(), (Integer) 4);
		assertEquals(result.get(1).get(1).getData(), (Integer) 8);

		// level 2
		assertEquals(result.get(2).get(0).getData(), (Integer) 3);
		assertEquals(result.get(2).get(1).getData(), (Integer) 5);
		assertEquals(result.get(2).get(2).getData(), (Integer) 7);
		assertEquals(result.get(2).get(3).getData(), (Integer) 9);
	}

}
