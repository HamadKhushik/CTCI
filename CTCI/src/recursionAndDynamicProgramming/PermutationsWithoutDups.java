/**
 * 
 */
package recursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * 8.7 Permutations of a String without duplicates
 * 
 * @author Hammad: 12-Dec-2021
 */
public class PermutationsWithoutDups {

	public ArrayList<String> getPerms(String str) {

		if (str == null) {
			return null;
		}

		ArrayList<String> permutations = new ArrayList<String>();
		// base case
		if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0); // remove first character and recurse rest of the string
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder); // recursive call

		for (String word : words) {

			// insert char(first) at every position in 'word' to get all the permutations of
			// the string(word)
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	// inserts a char(first) at (index) in a string(word)
	private String insertCharAt(String word, char first, int index) {

		String start = word.substring(0, index);
		String end = word.substring(index);
		return start + first + end;
	}

}
