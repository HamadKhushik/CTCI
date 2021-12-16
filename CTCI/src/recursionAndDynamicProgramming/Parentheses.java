/**
 * 
 */
package recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 8.9 An Algorithm to print all valid combinations of n pairs of parentheses
 * source : https://www.youtube.com/watch?v=eyCj_u3PoJE
 * 
 * @author Hammad: 16-Dec-2021
 */
public class Parentheses {

	/*
	 * inserts a set of parentheses at every opening parentheses '('. And adds a set
	 * of parentheses at the begining of every combination
	 * 
	 * This method does calculate duplicates but are handled by HashSet()
	 */
	public HashSet<String> generateParentheses(int n) {

		HashSet<String> set = new HashSet<String>();
		if (n == 0) {
			set.add("");
			return set;
		} else {

			HashSet<String> prev = generateParentheses(n - 1);
			for (String str : prev) {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') { // on every '('
						String s = insertParentheses(str, i); // insert a balances parentheses
						set.add(s);
					}
				}
				set.add("()" + str); // insert a balanced set of parentheses at the start of string
			}
		}

		return set;
	}

	// inserts a balanced set of parentheses at index
	private String insertParentheses(String str, int index) {

		String before = str.substring(0, index + 1);
		String after = str.substring(index + 1, str.length());

		return before + "()" + after;
	}

	/*
	 * This is the optimised version- as in it does not generate any duplicates
	 */
	public ArrayList<String> generateParentheses2(int n) {

		char[] str = new char[n * 2];
		ArrayList<String> result = new ArrayList<String>();

		generateParentheses(result, n, n, str, 0);

		return result;
	}

	/*
	 * this method inserts a left and right parentheses and recurses. IF it leads to
	 * a valid state, it is added to result otherwise ignored
	 */
	private void generateParentheses(ArrayList<String> result, int leftRemaining, int rightRemaining, char[] str,
			int index) {

		// invalid state
		if (leftRemaining < 0 || leftRemaining > rightRemaining) {
			return;
		}

		if (leftRemaining == 0 && rightRemaining == 0) {
			result.add(String.copyValueOf(str));
		}

		else {
			str[index] = '(';
			generateParentheses(result, leftRemaining - 1, rightRemaining, str, index + 1); // insert '(' and recurse

			str[index] = ')';
			generateParentheses(result, leftRemaining, rightRemaining - 1, str, index + 1); // insert ')' and recurse
		}

	}

}
