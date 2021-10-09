package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ValidateBSTTest {

	BinaryTreeNode<Integer> btn = new BinaryTreeNode<Integer>();
	BinaryTree<Integer> bt = new BinaryTree<Integer>();

	ValidateBST checkBST = new ValidateBST();

	@Before
	public void setUp() throws Exception {
		bt = bt.createBinaryTree();
		btn = bt.getRoot();

	}

	@Test
	public void isBSTTest() {

		boolean check = checkBST.isBST(btn);
		assertEquals(check, true);

		bt = new BinaryTree<Integer>();
		bt.add(17);
		bt.add(10);
		bt.add(22);
		bt.add(-5);
		bt.add(-6);
		bt.add(-14);
		bt.add(28);
		check = checkBST.isBST(bt.getRoot());
		assertEquals(check, true);

		btn = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> root = btn;
		btn.setLeft(new BinaryTreeNode<Integer>(5));
		btn.setRight(new BinaryTreeNode<Integer>(12));

		btn = btn.getLeft();// 5
		btn.setLeft(new BinaryTreeNode<Integer>(4));

		btn = btn.getLeft();// 4
		btn.setLeft(new BinaryTreeNode<Integer>(2));
		btn.setRight(new BinaryTreeNode<Integer>(8));

		btn = root.getRight(); // 12
		btn.setLeft(new BinaryTreeNode<Integer>(7));
		btn.setRight(new BinaryTreeNode<Integer>(14));

		check = checkBST.isBST(root);
		bt.printTree(root);
		assertEquals(check, false);
	}

	@Test
	public void isBST2Test() {

		boolean check = checkBST.isBST2(btn);
		assertEquals(check, true);

		bt = new BinaryTree<Integer>();
		bt.add(17);
		bt.add(10);
		bt.add(22);
		bt.add(-5);
		bt.add(-6);
		bt.add(-14);
		bt.add(28);
		checkBST = new ValidateBST();
		check = checkBST.isBST2(bt.getRoot());
		bt.printTree(bt.getRoot());
		assertEquals(check, true);

		btn = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> root = btn;
		btn.setLeft(new BinaryTreeNode<Integer>(5));
		btn.setRight(new BinaryTreeNode<Integer>(12));

		btn = btn.getLeft();// 5
		btn.setLeft(new BinaryTreeNode<Integer>(4));

		btn = btn.getLeft();// 4
		btn.setLeft(new BinaryTreeNode<Integer>(2));
		btn.setRight(new BinaryTreeNode<Integer>(8));

		btn = root.getRight(); // 12
		btn.setLeft(new BinaryTreeNode<Integer>(7));
		btn.setRight(new BinaryTreeNode<Integer>(14));

		checkBST = new ValidateBST();
		check = checkBST.isBST2(root);
		assertEquals(check, false);
	}

}
