/**
 * 
 */
package sortingAndSearching.rankFromStream;

/**
 * 10.10 Rank From Stream, RankNode class to represent a binary search tree
 * 
 * @author Hammad: 05-Jan-2022
 */
public class RankNode {

	int left_size = 0;
	RankNode left, right;
	int data;

	public RankNode(int d) {
		data = d;
	}

	public void insert(int x) {

		if (x <= data) {
			if (left != null) {
				left.insert(x);
			} else {
				left = new RankNode(x);
			}
			left_size++;
		} else {
			if (right != null) {
				right.insert(x);
			} else {
				right = new RankNode(x);
			}
		}
	}

	// returns the number of elements less than or equal to 'x'
	public int getRank(int x) {

		if (x == data) {
			return left_size;
		} else if (x < data) {
			if (left == null) {
				return -1;
			} else {
				return left.getRank(x);
			}
		} else {
			int right_size = right == null ? -1 : right.getRank(x);
			if (right_size == -1) {
				return -1;
			} else {
				return left_size + 1 + right.getRank(x);
			}
		}
	}
}
