package treesAndGraphs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class SuccessorNodeBSTTest {

	BinaryTree<Integer> bt = new BinaryTree<Integer>();
	BinaryTreeNode<Integer> btn = new BinaryTreeNode<Integer>();
	SuccessorNodeBST successor = new SuccessorNodeBST();

	@Before
	public void setUp() throws Exception {

		bt = bt.createBinaryTree();
		bt.printTree(bt.getRoot());
	}

	@Test
	public void findSuccessorTest() {

		btn = successor.findSuccessorNode(null);
		assertNull(btn);
		// successor of Node 6
		btn = successor.findSuccessorNode(bt.getRoot());
		assertEquals((Integer) 7, btn.getData());
		// successor of Node 8
		btn = successor.findSuccessorNode(bt.getRoot().getRight());
		assertEquals((Integer) 9, btn.getData());
		// successor of Node 9
		btn = successor.findSuccessorNode(bt.getRoot().getRight().getRight());
		assertNull(btn);
		// successor of Node 7
		btn = successor.findSuccessorNode(bt.getRoot().getRight().getLeft());
		assertEquals((Integer) 8, btn.getData());
		// successor of Node 4
		btn = successor.findSuccessorNode(bt.getRoot().getLeft());
		assertEquals((Integer) 5, btn.getData());
		// successor of Node 5
		btn = successor.findSuccessorNode(bt.getRoot().getLeft().getRight());
		assertEquals((Integer) 6, btn.getData());
		// successor of Node 3
		btn = successor.findSuccessorNode(bt.getRoot().getLeft().getLeft());
		assertEquals((Integer) 4, btn.getData());
	}

	@Test
	public void findSuccessorToNodeTest() {

		btn = successor.findSuccessorToNode(bt.getRoot(), null);
		assertNull(btn);
		// successor of Node 6
		btn = successor.findSuccessorToNode(bt.getRoot(), bt.getRoot());
		assertEquals((Integer) 7, btn.getData());
		// successor of Node 8
		btn = successor.findSuccessorToNode(bt.getRoot(), bt.getRoot().getRight());
		assertEquals((Integer) 9, btn.getData());
		// successor of Node 9
		btn = successor.findSuccessorToNode(bt.getRoot(), bt.getRoot().getRight().getRight());
		assertNull(btn);
		// successor of Node 7
		btn = successor.findSuccessorToNode(bt.getRoot(), bt.getRoot().getRight().getLeft());
		assertEquals((Integer) 8, btn.getData());
		// successor of Node 4
		btn = successor.findSuccessorToNode(bt.getRoot(), bt.getRoot().getLeft());
		assertEquals((Integer) 5, btn.getData());
		// successor of Node 5
		btn = successor.findSuccessorToNode(bt.getRoot(), bt.getRoot().getLeft().getRight());
		assertEquals((Integer) 6, btn.getData());
		// successor of Node 3
		btn = successor.findSuccessorToNode(bt.getRoot(), bt.getRoot().getLeft().getLeft());
		assertEquals((Integer) 4, btn.getData());
	}

}
