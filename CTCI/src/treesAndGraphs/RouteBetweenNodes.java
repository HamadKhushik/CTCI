package treesAndGraphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * 4.1 Route Between Nodes: given two nodes, find out if path exists between those two nodes
 * BFS is used in this solution
 */
public class RouteBetweenNodes {

	// finds and returns the shortest path from source to destination
	// returns null, if no path found
	public List<Node> findRoute(Graph graph, int from, int to) {

		if (graph == null) {
			return null;
		}

		if (from == to) {
			List<Node> list = new LinkedList<Node>();
			list.add(new Node(from));
			return list;
		}

		// initialize
		Queue<Node> queue = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();
		HashMap<Node, Node> path = new HashMap<Node, Node>();
		Node source = graph.getNode(from);
		Node destination = graph.getNode(to);

		// bfs
		if (bfs(queue, visited, path, source, destination)) {
			return constructPath(path, destination, source);
		}

		return null;
	}

	// bfs
	public boolean bfs(Queue<Node> queue, Set<Node> visited, HashMap<Node, Node> path, Node source, Node destination) {

		if (source.equals(destination)) {
			return true;
		}

		queue.add(source);
		visited.add(source);

		// bfs algorithm
		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			for (Node neighbour : curr.getNeighbours()) {

				if (!visited.contains(neighbour)) {
					queue.add(neighbour);
					visited.add(neighbour);

					// because this code is re-used in pathhExists(), where map is not required and
					// passed as 'null'
					if (path != null) {
						path.put(neighbour, curr);
					}

					// destination found!!
					if (neighbour.equals(destination)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public List<Node> constructPath(HashMap<Node, Node> path, Node destination, Node from) {

		List<Node> listPath = new LinkedList<Node>();
		Node temp = destination;

		listPath.add(destination);

		// every Node remembers its previous Node, add all of them and we have a path!!
		while (path.get(temp) != null) {
			Node pred = path.get(temp);
			listPath.add(pred);
			temp = pred;
		}

		return listPath;
	}

	// check if path exists from source/start to destination/end
	public boolean pathExists(Graph graph, int from, int to) {

		// initialize
		Queue<Node> queue = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();
		Node source = graph.getNode(from);
		Node destination = graph.getNode(to);

		return bfs(queue, visited, null, source, destination);
	}

	// solution in the book to check if path exists
	public boolean search(Graph graph, int from, int to) {

		if (from == to) {
			return true;
		}

		// queue
		LinkedList<Node> q = new LinkedList<Node>();
		// visited
		Set<Node> visited = new HashSet<Node>();

		Node start = graph.getNode(from);
		Node end = graph.getNode(to);

		q.add(start);
		visited.add(start);

		while (!q.isEmpty()) {
			Node curr = q.removeFirst();

			if (curr != null) {
				for (Node neighbour : curr.getNeighbours()) {
					if (!visited.contains(neighbour)) {
						if (neighbour.equals(end)) {
							return true;
						} else {
							q.add(neighbour);
							visited.add(neighbour);
						}
					}
				}
			}
		}
		return false;
	}
}
