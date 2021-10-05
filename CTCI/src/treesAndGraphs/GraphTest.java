package treesAndGraphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	Graph graph = new Graph();

	@Before
	public void setUp() throws Exception {

		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);

		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(4, 3);
		graph.addEdge(4, 5);
		graph.addEdge(5, 4);
		graph.addEdge(5, 1);
		graph.addEdge(1, 5);
	}

	@Test
	public void addVertex() {
		graph.addVertex(1);
		assertEquals(5, graph.getNoOfVertices());
		graph.addVertex(6);
		assertEquals(6, graph.getNoOfVertices());
	}

	@Test
	public void addEdge() {
		graph.addEdge(1, 2);
		assertEquals(10, graph.getNoOfEdges());

		graph.addEdge(5, 6);
		assertEquals(10, graph.getNoOfEdges());

		graph.addVertex(6);
		graph.addEdge(5, 6);
		assertEquals(11, graph.getNoOfEdges());
		graph.addEdge(6, 5);
		assertEquals(12, graph.getNoOfEdges());
		graph.printGraph();

	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.constructGraph();

		Node source = new Node(1);

		System.out.println(source.getNeighbours());
	}
}
