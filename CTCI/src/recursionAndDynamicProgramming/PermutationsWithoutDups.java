/**
 * 
 */
package recursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * 8.7 Permutations of a String without duplicates. Assume all characters in the
 * String will be unique
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

	public ArrayList<String> getPerms2(String remainder) {

		if (remainder == null) {
			return null;
		}

		int len = remainder.length();
		ArrayList<String> result = new ArrayList<String>();

		if (len == 0) {
			result.add("");
			return result;
		}

		/*
		 * get all permutations of n-1 characters and then add nth character in second
		 * loop
		 */
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			ArrayList<String> partials = getPerms2(before + after);

			for (String s : partials) {
				result.add(remainder.charAt(i) + s);
			}
		}
		return result;
	}

	public ArrayList<String> getPerms3(String remainder) {

		if (remainder == null) {
			return null;
		}

		ArrayList<String> result = new ArrayList<String>();
		getPerms3("", remainder, result);
		return result;
	}

	private void getPerms3(String prefix, String remainder, ArrayList<String> result) {

		int len = remainder.length();
		if (len == 0) {
			result.add(prefix);
		}

		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			getPerms3(prefix + c, before + after, result);
		}
	}
}
