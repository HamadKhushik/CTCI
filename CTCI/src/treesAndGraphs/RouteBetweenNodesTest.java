package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RouteBetweenNodesTest {

	Graph graph = new Graph();
	RouteBetweenNodes route = new RouteBetweenNodes();

	@Before
	public void setUp() throws Exception {

		graph.constructGraph();
	}

	@Test
	public void findRoutesTest() {
		List<Node> path = new LinkedList<Node>();
		path.add(new Node(3));
		path.add(new Node(2));
		path.add(new Node(1));
		assertEquals(path, route.findRoute(graph, 1, 3));

		path.clear();
		path.add(new Node(4));
		path.add(new Node(5));
		path.add(new Node(1));
		assertEquals(path, route.findRoute(graph, 1, 4));

		path.clear();
		assertEquals(null, route.findRoute(graph, 1, 7));

		path.add(new Node(1));
		assertEquals(path, route.findRoute(graph, 1, 1));
	}

	@Test
	public void pathExistsTest() {
		assertEquals(true, route.pathExists(graph, 1, 3));
		assertEquals(true, route.pathExists(graph, 1, 4));
		assertEquals(true, route.pathExists(graph, 1, 5));
		assertEquals(false, route.pathExists(graph, 1, 7));
		assertEquals(true, route.pathExists(graph, 1, 1));
	}

	@Test
	public void searhTest() {
		assertEquals(true, route.search(graph, 1, 3));
		assertEquals(true, route.search(graph, 1, 4));
		assertEquals(true, route.search(graph, 1, 5));
		assertEquals(false, route.search(graph, 1, 7));
		assertEquals(true, route.search(graph, 1, 1));
	}
}
