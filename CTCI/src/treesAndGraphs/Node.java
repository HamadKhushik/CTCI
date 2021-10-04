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
