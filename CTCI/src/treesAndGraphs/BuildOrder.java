package treesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
 * 4.7 Build Order - 
 * solution is based on DFS (Topological sort )
 * 
 * edge 1 -> 2 is defined as 1 is dependent on 2
 */
public class BuildOrder {

	/*
	 * builds order to execute the processes Tushar Roy - Coding Made Simple
	 * solution order can be different depending on which node is visited first but
	 * all the dependencies must be visited first
	 * 
	 * Topological sort based on dfs - this solution does not detect cycles
	 */
	public List<Integer> sortOrder(Graph g) {

		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		for (Node node : g.getVertices().values()) {
			if (!visited.contains(node.getId())) {
				sortOrderUtil(node, visited, stack);
			}
		}
		// pop the nodes to return the correct(Topological order) order
		List<Integer> result = new ArrayList<Integer>();
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}

		return result;
	}

	public void sortOrderUtil(Node node, Set<Integer> visited, Stack<Integer> stack) {

		visited.add(node.getId());
		for (Node neighbour : node.getNeighbours()) {
			if (!visited.contains(neighbour.getId())) {
				sortOrderUtil(neighbour, visited, stack);
			}
		}
		stack.push(node.getId());
	}

	/*
	 * Solution based on 'book' Topological Sort all the nodes with no dependency
	 * are added first
	 * 
	 * two dimensional array is passed as arguments for dependencies edge a -> b
	 * represents 'a' must be built before 'b'. in other words 'b' is dependent on
	 * 'a'
	 */
	public List<Node> buildOrderBook(Integer[] projects, Integer[][] dependencies) {

		List<Node> result = new ArrayList<Node>();

		// build graph
		Graph graph = buildGraph(dependencies);

		if (graph == null) {
			return null;
		}

		addNodesWithNoDependency(result, graph);

		int toBeProcessed = 0;

		while (toBeProcessed < graph.getNoOfVertices()) {

			/*
			 * check for cyclic dependency if toBeProcessed >= result.size() means there are
			 * no nodes without dependency - in other words every node depends on other node
			 * i-e cyclic dependency
			 */
			if (toBeProcessed >= result.size()) {
				return null;
			}

			// List result only contains nodes with no dependency
			Node current = result.get(toBeProcessed);

			for (Node node : current.getNeighbours()) {

				int incomingEdges = node.getIncomingEdges();
				node.setIncomingEdges(--incomingEdges);
			}

			addNodesWithNoDependency(result, graph);
			toBeProcessed++;
		}
		return result;
	}

	/*
	 * adds the nodes with no dependency(nodes with no incoming edges) to the result
	 * List
	 */
	public void addNodesWithNoDependency(List<Node> result, Graph g) {

		for (Node node : g.getVertices().values()) {
			if (node.getIncomingEdges() == 0 && !result.contains(node)) {
				result.add(node);
			}
		}
	}

	public Graph buildGraph(Integer[][] dependencies) {

		if (dependencies.length == 0) {
			return null;
		}

		Graph graph = new Graph();

		for (Integer[] i : dependencies) {

			// i[1] is dependent on i[0] means i[0] must be built first
			graph.addVertex(i[0]);
			graph.addVertex(i[1]);
			graph.addEdge(i[0], i[1]);
		}

		return graph;
	}

	/*
	 * Book solution based on dfs
	 */

	public List<Node> orderProjects(Integer[] projects, Integer[][] dependencies) {

		Graph graph = buildGraph(dependencies);

		setNodeStates(graph);

		Stack<Node> stack = new Stack<Node>();

		for (Node node : graph.getVertices().values()) {

			if (node.getNodeState() == State.UNVISITED) {
				if (!doDFS(node, stack)) {
					return null;
				}
			}
		}
		List<Node> result = new ArrayList<Node>();
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		return result;
	}

	private boolean doDFS(Node n, Stack<Node> stack) {

		// cycle check
		if (n.getNodeState() == State.VISITING) {
			return false;
		}

		// if node is unvisited, visit it and add it to stack
		if (n.getNodeState() == State.UNVISITED) {
			n.setNodeState(State.VISITING);
			for (Node neighbour : n.getNeighbours()) {

				if (!doDFS(neighbour, stack)) {
					return false;
				}
			}
			n.setNodeState(State.VISITED);
			stack.push(n);
		}

		return true;
	}

	// set all node states to UNVISITED
	private void setNodeStates(Graph g) {

		for (Node n : g.getVertices().values()) {
			n.setNodeState(State.UNVISITED);
		}
	}
}
