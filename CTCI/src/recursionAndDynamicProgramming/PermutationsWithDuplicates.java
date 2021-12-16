/**
 * 
 */
package recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 8.8, Print all the permutations of a String containing duplicates.
 * 
 * eg: aabc/abbbc.
 * 
 * source: https://www.youtube.com/watch?v=nYFd7VHKyWQ
 * 
 * @author Hammad: 15-Dec-2021
 */
public class PermutationsWithDuplicates {

	// only evaluates unique permutations of a String
	public ArrayList<String> printPerms(String str) {

		if (str == null) {
			return null;
		}
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		buildHashMap(str, map);

		printPerms(map, "", str.length(), result);

		return result;
	}

	private void buildHashMap(String str, HashMap<Character, Integer> map) {

		for (char c : str.toCharArray()) {

			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
	}

	private void printPerms(HashMap<Character, Integer> map, String prefix, Integer remaining,
			ArrayList<String> result) {

		// base case
		if (remaining == 0) {
			result.add(prefix);
			return;
		}

		for (Character c : map.keySet()) {

			int count = map.get(c);

			if (count > 0) {
				map.put(c, count - 1);
				printPerms(map, prefix + c, remaining - 1, result);
				map.put(c, count);
			}
		}
	}

}
