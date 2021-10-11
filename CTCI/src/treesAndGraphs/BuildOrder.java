package treesAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * 4.7 Build Order - 
 * solution is based on DFS (Topological sort )
 * 
 * edge 1 -> 2 is defined as 1 is dependent on 2
 */
public class BuildOrder {

	// builds order to execute the processes
	public List<Integer> sortOrder(Graph g) {

		Set<Integer> visited = new HashSet<Integer>();
		List<Integer> stack = new LinkedList<Integer>();

		for (Node node : g.getVertices().values()) {
			if (!visited.contains(node.getId())) {
				sortOrderUtil(node, visited, stack);
			}
		}
		return stack;
	}

	public void sortOrderUtil(Node node, Set<Integer> visited, List<Integer> stack) {

		visited.add(node.getId());
		for (Node neighbour : node.getNeighbours()) {
			if (!visited.contains(neighbour.getId())) {
				sortOrderUtil(neighbour, visited, stack);
			}
		}
		stack.add(node.getId());
	}

}
