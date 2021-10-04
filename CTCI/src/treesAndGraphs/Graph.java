package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/*
 * basic Graph implementation
 */
public class Graph {

	List<Node> vertices;
	int noOfVertices;
	int noOfEdges;

	public Graph() {
		vertices = new ArrayList<Node>();
		noOfVertices = 0;
		noOfEdges = 0;
	}

	public void addVertex(int v) {

		Node vert = new Node(v);

		if (vertices.contains(vert)) {
			return;
		}
		vertices.add(vert);
		noOfVertices++;
	}

	public boolean addEdge(int from, int to) {

		Node source = null;
		Node destination = null;
		for (int i = 0; i < vertices.size(); i++) {
			Node temp = vertices.get(i);
			if (temp.getId() == from) {
				source = temp;
			}
			if (temp.getId() == to) {
				destination = temp;
			}
		}

		// edge can not be added if vertex do not exist
		if (source == null || destination == null) {
			System.out
					.println("Graph class: addEdge method. source " + from + " or destination " + to + " do not exist");
			return false;
		} else if (source.getNeighbours().contains(destination)) {
			return true;
		}

		noOfEdges++;
		return source.addNeighbours(destination);
	}

	public void printGraph() {

		for (Node curr : vertices) {

			System.out.println("neighbours for Node: " + curr);
			// System.out.println("curr neighbours: " + curr.getNeighbours());

			for (Node neighbour : curr.getNeighbours()) {
				System.out.print(neighbour + ", ");
			}
			System.out.println("\n");
		}
	}

	// so that i dont have to construct graph everytime for testing
	public void constructGraph() {

		this.addVertex(1);
		this.addVertex(2);
		this.addVertex(3);
		this.addVertex(4);
		this.addVertex(5);

		this.addEdge(1, 2);
		this.addEdge(2, 1);
		this.addEdge(2, 3);
		this.addEdge(3, 2);
		this.addEdge(3, 4);
		this.addEdge(4, 3);
		this.addEdge(4, 5);
		this.addEdge(5, 4);
		this.addEdge(5, 1);
		this.addEdge(1, 5);

	}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public int getNoOfEdges() {
		return noOfEdges;
	}

	public List<Node> getVertices() {
		return vertices;
	}

}
