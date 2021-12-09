/**
 * 
 */
package recursionAndDynamicProgramming;

import java.util.Arrays;

/**
 * practice question 8.1. calculate number of ways to climb n stairs when taking
 * 1 or 2 or 3 steps at a time. This is almost like fibonacci series except the
 * case with '0' steps
 * 
 * @author Hammad: 08-Dec-2021
 */
public class TripleStep {

	// Basic Recursive Approach
	public int countWays(int n) {

		if (n < 0) {
			return 0;
		}
		// base case
		if (n == 0) {
			return 1;
		}
		return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
	}

	// Dynamic programming approach using memoization
	public int countWaysMemoization(int n) {

		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countWaysMemoization(n, memo);
	}

	private int countWaysMemoization(int i, int[] memo) {

		if (i < 0) {
			return 0;
		}

		if (i == 0) {
			return 1;
		}

		if (memo[i] < 0) {
			// because 1, 2 or three steps are allowed at a time
			memo[i] = countWaysMemoization(i - 1, memo) + countWaysMemoization(i - 2, memo)
					+ countWaysMemoization(i - 3, memo);
		}
		return memo[i];
	}

}
