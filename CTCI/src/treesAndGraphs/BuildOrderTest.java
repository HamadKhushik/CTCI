package treesAndGraphs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BuildOrderTest {

	BuildOrder bo = new BuildOrder();
	Graph graph = new Graph();
	List<Integer> result = new ArrayList<Integer>();

	// for buildOrderBookTest
	Integer[][] dependencies = { { 6, 3 }, { 6, 2 }, { 4, 7 }, { 3, 1 }, { 2, 1 }, { 1, 5 } }; // {a, b} means 'a' must
																								// be
																								// built before 'b'
	Integer[] projects = { 1, 2, 3, 4, 5, 6, 7 };

	List<Node> dependencyOrder = new ArrayList<Node>();

	@Before
	public void setUp() throws Exception {

		graph.construtGraph("src\\treesAndGraphs\\Util\\defaultGraph.txt");
	}

	@Test
	public void processOrderTest() {

		result = bo.sortOrder(graph);
		System.out.println("processOrderTest " + result);
		assertEquals((Integer) 2, result.get(0));
		assertEquals((Integer) 5, result.get(1));
		assertEquals((Integer) 1, result.get(2));
		assertEquals((Integer) 3, result.get(3));
		assertEquals((Integer) 4, result.get(4));

		graph = new Graph();
		result = new ArrayList<Integer>();
		graph.construtGraph("src\\treesAndGraphs\\Util\\testCaseBook.txt");
		result = bo.sortOrder(graph);
		System.out.println("processOrderTest " + result);
		assertEquals((Integer) 6, result.get(0));
		assertEquals((Integer) 5, result.get(1));
		assertEquals((Integer) 2, result.get(2));
		assertEquals((Integer) 1, result.get(3));
		assertEquals((Integer) 4, result.get(4));

		graph = new Graph();
		result = new ArrayList<Integer>();
		graph.construtGraph("src\\treesAndGraphs\\Util\\testCase.txt");

	}

	@Test
	public void buildOrderBookTest() {

		graph = new Graph();
		graph = bo.buildGraph(dependencies);
		dependencyOrder = bo.buildOrderBook(projects, dependencies);
		System.out.println("dependeny Order " + dependencyOrder);

		assertEquals(4, dependencyOrder.get(0).getId());
		assertEquals(6, dependencyOrder.get(1).getId());
		assertEquals(7, dependencyOrder.get(2).getId());
		assertEquals(2, dependencyOrder.get(3).getId());
		assertEquals(3, dependencyOrder.get(4).getId());

		graph = new Graph();
		dependencyOrder = new ArrayList<Node>();
		Integer[] project2 = { 1, 2, 3 };
		// cyclic dependency check
		Integer[][] dependencies2 = { { 1, 2 }, { 2, 3 }, { 3, 1 } };
		dependencyOrder = bo.buildOrderBook(project2, dependencies2);
		System.out.println("dependeny Order2 " + dependencyOrder);
		assertNull(dependencyOrder);

	}

}
