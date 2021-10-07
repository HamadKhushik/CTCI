package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MinimalTreeTest {

	int[] array = { -10, -5, -3, 0, 5, 8, 9 };
	MinimalTree mt = new MinimalTree();
	BinaryTree<Integer> bt = new BinaryTree<Integer>();

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void bstFromSortedArrayTest() {
		bt = mt.bstFromSortedArray(array);
		BinaryTreeNode<Integer> node = bt.getRoot();
		assertEquals(node.getData(), (Integer) 0);
		bt.printTree(node);

		node = node.getLeft();
		assertEquals(node.getData(), Integer.valueOf(-5));

		int[] array2 = { -10, -5, 0, 5, 8, 9 };
		bt = mt.bstFromSortedArray(array2);
		bt.printTree(bt.getRoot());

	}

}
