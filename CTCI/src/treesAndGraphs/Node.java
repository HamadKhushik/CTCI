package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/*
 * basic Node for graphs and trees
 */
enum State {
	UNVISITED, VISITED, VISITING
}

public class Node {

	private int id;
	private List<Node> neighbours;
	public State nodeState;
	private int incomingEdges;

	public Node(int id) {
		this.id = id;
		neighbours = new ArrayList<Node>();
		incomingEdges = 0;
	}

	public int getIncomingEdges() {
		return incomingEdges;
	}

	public void setIncomingEdges(int incomingEdges) {
		this.incomingEdges = incomingEdges;
	}

	public int getId() {
		return this.id;
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public boolean addNeighbours(Node newNeighbour) {

		if (this.neighbours.contains(newNeighbour)) {
			return true;
		}
		neighbours.add(newNeighbour);

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

}
