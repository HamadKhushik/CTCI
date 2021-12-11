/**
 * 
 */
package recursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * 8.4, Calculate all the subsets of a set
 * 
 * @author Hammad: 11-Dec-2021
 */
public class PowerSet {

	// uses Recursion, O(n) = n*2pow(n)
	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {

		ArrayList<ArrayList<Integer>> allSubsets;

		if (index == set.size()) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		} else {
			allSubsets = getSubsets(set, index + 1);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			int item = set.get(index);
			for (ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}

	// solution using Bit-wise Operators
	public ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {

		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();

		for (int i = 0; i < max; i++) {
			ArrayList<Integer> subsets = convertIntToSet(set, i);
			allSubsets.add(subsets);
		}
		return allSubsets;
	}

	private ArrayList<Integer> convertIntToSet(ArrayList<Integer> set, int x) {

		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;

		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
}
