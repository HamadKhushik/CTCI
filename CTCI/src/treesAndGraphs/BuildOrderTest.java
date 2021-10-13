package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BuildOrderTest {

	BuildOrder bo = new BuildOrder();
	Graph graph = new Graph();
	List<Integer> result = new ArrayList<Integer>();

	@Before
	public void setUp() throws Exception {

		graph.construtGraph("src\\treesAndGraphs\\Util\\defaultGraph.txt");
	}

	@Test
	public void processOrderTest() {

		result = bo.sortOrder(graph);
		System.out.println(result);
		assertEquals((Integer) 2, result.get(0));
		assertEquals((Integer) 5, result.get(1));
		assertEquals((Integer) 1, result.get(2));
		assertEquals((Integer) 3, result.get(3));
		assertEquals((Integer) 4, result.get(4));

		graph = new Graph();
		result = new ArrayList<Integer>();
		graph.construtGraph("src\\treesAndGraphs\\Util\\testCaseBook.txt");
		result = bo.sortOrder(graph);
		System.out.println(result);
		assertEquals((Integer) 6, result.get(0));
		assertEquals((Integer) 5, result.get(1));
		assertEquals((Integer) 2, result.get(2));
		assertEquals((Integer) 1, result.get(3));
		assertEquals((Integer) 4, result.get(4));

		graph = new Graph();
		result = new ArrayList<Integer>();
		graph.construtGraph("src\\treesAndGraphs\\Util\\testCase.txt");

	}

}
