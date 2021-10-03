package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/*
 * basic Node for graphs and trees
 */
public class Node {

	int id;
	List<Node> neighbours;

	public Node(int id) {
		this.id = id;
		neighbours = new ArrayList<Node>();
	}

	public int getId() {
		return this.id;
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

}
