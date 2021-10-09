package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CheckBalanceTest {

	CheckBalance cb = new CheckBalance();
	BinaryTree<Integer> bt = new BinaryTree<Integer>();
	BinaryTreeNode<Integer> btn = new BinaryTreeNode<Integer>();

	@Before
	public void setUp() throws Exception {
		bt = bt.createBinaryTree();
		btn = bt.getRoot();
	}

	@Test
	public void isBalanedTest() {
		boolean checkBalance = cb.isBalanced(btn);
		assertEquals(true, checkBalance);

		bt.add(2);
		checkBalance = cb.isBalanced(btn);
		assertEquals(true, checkBalance);

		bt.add(10);
		checkBalance = cb.isBalanced(btn);
		assertEquals(true, checkBalance);

		bt.add(11);
//		bt.printTree(btn);
		checkBalance = cb.isBalanced(btn);
		assertEquals(false, checkBalance);

	}

	@Test
	public void isBalanedEfficientTest() {
		boolean checkBalance = cb.isBalancedEfficient(btn);
		assertEquals(true, checkBalance);

		bt.add(2);
		checkBalance = cb.isBalancedEfficient(btn);
//		bt.printTree(btn);
		assertEquals(true, checkBalance);

		bt.add(1);
		checkBalance = cb.isBalancedEfficient(btn);
//		bt.printTree(btn);
		assertEquals(false, checkBalance);

		bt.add(0);
		checkBalance = cb.isBalancedEfficient(btn);
//		bt.printTree(btn);
		assertEquals(false, checkBalance);

		bt.add(10);
		checkBalance = cb.isBalancedEfficient(btn);
//		bt.printTree(btn);
		assertEquals(false, checkBalance);

		bt.add(11);
		checkBalance = cb.isBalancedEfficient(btn);
		bt.printTree(btn);
		assertEquals(false, checkBalance);

	}

}
