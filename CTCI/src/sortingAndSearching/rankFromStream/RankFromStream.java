/**
 * 
 */
package sortingAndSearching.rankFromStream;

/**
 * 10.10 Rank From Stream
 * 
 * @author Hammad: 05-Jan-2022
 */
public class RankFromStream {

	RankNode root;

	public void track(int x) {

		if (root == null) {
			root = new RankNode(x);
			return;
		} else {
			root.insert(x);
		}
	}

	public int getRank(int x) {

		return root.getRank(x);
	}

}
