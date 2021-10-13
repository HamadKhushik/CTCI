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
	 * Topological sort based on dfs
	 */
	public List<Integer> sortOrder(Graph g) {

		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		for (Node node : g.getVertices().values()) {
			if (!visited.contains(node.getId())) {
				sortOrderUtil(node, visited, stack);
			}
		}
		// pop the nodes to return the correct order
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
	 * represents a must be built before b. in other words b is dependent on a
	 */
	public List<Integer> buildOrderBook(Integer[] projects, Integer[][] dependenies) {

		return null;
	}

	public Graph buildGraph(Integer[][] dependencies) {

		Graph graph = new Graph();

		for (Integer[] i : dependencies) {

			graph.addVertex(i[0]);
			graph.addVertex(i[1]);
			graph.addEdge(i[0], i[1]);
		}

		return graph;
	}

}
