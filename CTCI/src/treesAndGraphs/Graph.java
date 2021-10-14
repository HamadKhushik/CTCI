package treesAndGraphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/*
 * basic Graph implementation
 */
public class Graph {

	HashMap<Integer, Node> vertices;
	int noOfVertices;
	int noOfEdges;

	public Graph() {
		vertices = new HashMap<Integer, Node>();
		noOfVertices = 0;
		noOfEdges = 0;
	}

	public void addVertex(int v) {

		if (vertices.containsKey(v)) {
			return;
		}

		Node vert = new Node(v);
		vertices.put(v, vert);
		noOfVertices++;
	}

	public boolean addEdge(int from, int to) {

		Node source = vertices.get(from);
		Node destination = vertices.get(to);

		// edge can not be added if vertex do not exist
		if (source == null || destination == null) {
			System.out
					.println("Graph class: addEdge method. source " + from + " or destination " + to + " do not exist");
			return false;
		} else if (source.getNeighbours().contains(destination)) {
			return true;
		}

		noOfEdges++;
		int destEdges = destination.getIncomingEdges();
		destination.setIncomingEdges(destEdges++);
		return source.addNeighbours(destination);
	}

	public void printGraph() {

		for (Node curr : vertices.values()) {

			System.out.println("neighbours for Node: " + curr);
			// System.out.println("curr neighbours: " + curr.getNeighbours());

			for (Node neighbour : curr.getNeighbours()) {
				System.out.print(neighbour + ", ");
			}
			System.out.println("\n");
		}
	}

	//
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

	// construct graph from file
	public void construtGraph(String filename) {

		try {
			File f = new File(filename);
			Scanner scanner = new Scanner(f);

			while (scanner.hasNextLine()) {
				String str = scanner.nextLine();

				// if line is empty
				if (str.length() == 0) {
					continue;
				}

				String[] line = str.split(" ");

				int vert1 = Integer.parseInt(line[0]);
				this.addVertex(vert1);

				if (line.length > 1 && line[1] != null) {
					int vert2 = Integer.valueOf(line[1]);
					this.addVertex(vert2);
					this.addEdge(vert1, vert2);
				}

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public int getNoOfEdges() {
		return noOfEdges;
	}

	public HashMap<Integer, Node> getVertices() {
		return vertices;
	}

	public Node getNode(int node) {
		return vertices.get(node);
	}
}
