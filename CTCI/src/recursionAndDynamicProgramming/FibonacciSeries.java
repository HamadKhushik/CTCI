package recursionAndDynamicProgramming;

/*
 * Fibonacci series Practice question
 */
public class FibonacciSeries {

	// Standard recursive method
	public int fibonacciRecursive(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	/*
	 * Top down Dynamic Programming example results are cached in an array to be
	 * utilised later on instead of calculating every time
	 */
	public int fibonacciDynamic(int n) {

		return fibonacciHelper(n, new int[n + 1]);
	}

	private int fibonacciHelper(int i, int[] memo) {

		if (i == 0 || i == 1) {
			return i;
		}

		if (memo[i] == 0) {
			memo[i] = fibonacciHelper(i - 1, memo) + fibonacciHelper(i - 2, memo);
		}

		return memo[i];
	}

	/*
	 * Fibonacci series implementation using the Bottom Up Dynamic programming
	 * approach -> calculate the base cases and use those results for other
	 * calculations
	 */
	public int fibonacciBottomUp(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;

		for (int i = 2; i < n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}

		return memo[n - 1] + memo[n - 2];
	}

	/*
	 * Dynamic Programming Bottom Up Approach taking advantage of the fact that only
	 * last two values are required to calculate the next number. so, an array is
	 * not required - just two variables
	 */
	public int fibonacciBottomUpOptimised(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int a = 0;
		int b = 1;

		for (int i = 2; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}
}
