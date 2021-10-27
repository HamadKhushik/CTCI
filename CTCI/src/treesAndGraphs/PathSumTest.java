package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PathSumTest {

	PathSum ps = new PathSum();
	BinaryTree<Integer> bt = new BinaryTree<Integer>();
	BinaryTreeNode<Integer> root = bt.getRoot();

	@Before
	public void setUp() throws Exception {

		bt.add(10);
		bt.addLeft(bt.getRoot(), 5);
		bt.addRight(bt.getRoot(), -3);
		bt.addRight(bt.getRoot().getRight(), 11);
		bt.addLeft(bt.getRoot().getLeft(), 3);
		bt.addRight(bt.getRoot().getLeft(), 2);
		bt.addRight(bt.getRoot().getLeft().getRight(), 1);
		bt.addLeft(bt.getRoot().getLeft().getLeft(), 4);
		bt.addRight(bt.getRoot().getLeft().getLeft(), -2);
		bt.printTree(bt.getRoot());

	}

	@Test
	public void countPathWithSumTest() {

		int sum = ps.countPathsWithSum(bt.getRoot(), 8);
		assertEquals(3, sum);

		sum = ps.countPathsWithSum(bt.getRoot(), 8);
		assertEquals(3, sum);
	}

	@Test
	public void countSumOptimisedTest() {

		int sum = ps.countSumOptimised(bt.getRoot(), 8);
		assertEquals(3, sum);

		sum = ps.countSumOptimised(bt.getRoot(), 8);
		assertEquals(3, sum);
	}

}
