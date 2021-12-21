/**
 * 
 */
package recursionAndDynamicProgramming;

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
			return StringToBool(s) ? 1 : 0;
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
			int subWays = result ? totalTrue : total - totalTrue;

			ways += subWays;
		}
		return ways;
	}

	private static boolean StringToBool(String s) {

		return s.equals("1") ? true : false;
	}
}
