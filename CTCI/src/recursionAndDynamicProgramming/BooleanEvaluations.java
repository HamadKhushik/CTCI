/**
 * 
 */
package recursionAndDynamicProgramming;

import java.util.HashMap;

/**
 * 8.14 Boolean Evaluations: evaluate the number of ways to parenthesise a
 * boolean string to get desired result (true or false)
 * 
 * @author Hammad: 21-Dec-2021
 */
public class BooleanEvaluations {

	public static int countEval(String s, boolean result) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		// base case
		if (s.length() == 1) {
			// if string('0' or '1') is same as expected result, return '1' else return '0'
			return StringToBool(s) == result ? 1 : 0;
		}

		int ways = 0;

		for (int i = 1; i < s.length(); i += 2) {

			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());

			// evaluate all the expressions
			int leftTrue = countEval(left, true);
			int leftFalse = countEval(left, false);
			int rightTrue = countEval(right, true);
			int rightFalse = countEval(right, false);
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

			int totalTrue = 0;
			// evaluate wrt current expression
			if (c == '&') {
				totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {
				totalTrue = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (c == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			}

			// if result is true - return totalTrue else return total - totalTrue
			int subWays = result ? totalTrue : total - totalTrue; // if total = totalTrue + totalFalse, then totalFalse
																	// = total - totalTrue

			ways += subWays;
		}
		return ways;
	}

	// converts single length string into true-if its '1' or false- if its '0'
	private static boolean StringToBool(String s) {

		return s.equals("1") ? true : false;
	}

	/**
	 * using memoization
	 */
	public static int countEval(String s, boolean result, HashMap<String, Integer> memo) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		if (s.length() == 1) {
			return StringToBool(s) == result ? 1 : 0;
		}

		if (memo.containsKey(result + s)) {
			return memo.get(result + s);
		}

		int ways = 0;

		for (int i = 1; i < s.length(); i += 2) {

			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());

			// evaluate all the expressions
			int leftTrue = countEval(left, true, memo);
			int leftFalse = countEval(left, false, memo);
			int rightTrue = countEval(right, true, memo);
			int rightFalse = countEval(right, false, memo);
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

			int totalTrue = 0;

			if (c == '&') {
				totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {
				totalTrue = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (c == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			}

			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}

		// cache the results
		memo.put(result + s, ways);
		return ways;
	}
}
