package linkedllist;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class IntersectionTest {

	Integer[] array;
	Integer[] array2;
	Integer[] array3;
	Node list1;
	Node list2;
	Node list3;
	Node seven;
	Node two;
	Node one;

	@Before
	public void setUp() throws Exception {

		array = new Integer[] { 3, 1, 5, 9 };
		array2 = new Integer[] { 4, 6 };
		array3 = new Integer[] { 1, 2 };
		list1 = Node.createLinkedList(Arrays.asList(array));
		list2 = Node.createLinkedList(Arrays.asList(array2));
		list3 = Node.createLinkedList(Arrays.asList(array3));
		seven = new Node(7);
		two = new Node(2);
		one = new Node(1);
		list1.appendAtTail(seven);
		list1.appendAtTail(two);
		list1.appendAtTail(one);
		list2.appendAtTail(seven);
		list3.appendAtTail(one);
	}

	@Test
	public void inrementPointerTest() {
		assertEquals(seven, new Intersection().incrementPointer(list1, 4));
		assertEquals(two, new Intersection().incrementPointer(list1, 5));
		assertEquals(one, new Intersection().incrementPointer(list1, 6));
	}

	@Test
	public void findIntersectingNodeTest() {
		assertEquals(seven, new Intersection().findIntersetingNode(list1, list2));
		assertEquals(one, new Intersection().findIntersetingNode(list1, list3));
		assertEquals(null, new Intersection().findIntersetingNode(list1, null));
	}

}
