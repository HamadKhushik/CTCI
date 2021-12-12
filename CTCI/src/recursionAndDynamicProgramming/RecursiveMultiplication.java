/**
 * 
 */
package recursionAndDynamicProgramming;

/**
 * 8.5 Recursive Multiplication
 * 
 * @author Hammad: 11-Dec-2021
 */
public class RecursiveMultiplication {

	public int minProduct(int a, int b) {

		int smaller = a < b ? a : b;
		int bigger = a > b ? a : b;

		return minProductHelper(smaller, bigger);
	}

	private int minProductHelper(int smaller, int bigger) {

		if (smaller == 0) {
			return 0;
		}
		if (smaller == 1) {
			return bigger;
		}

		int s = smaller >> 1;
		int side1 = minProductHelper(s, bigger);
		int side2 = side1;

		if (smaller % 2 == 1) {
			side2 = minProductHelper(smaller - s, bigger);
		}
		return side1 + side2;
	}

	// same recursive approach but using Dynamic Programming (memoisation)
	public int minProduct2(int a, int b) {

		int smaller = a < b ? a : b;
		int bigger = a > b ? a : b;
		int[] memo = new int[smaller + 1];

		return minProductHelper2(smaller, bigger, memo);
	}

	public int minProductHelper2(int smaller, int bigger, int[] memo) {

		if (smaller == 0) {
			return 0;
		}
		if (smaller == 1) {
			return bigger;
		}

		if (memo[smaller] > 0) {
			return memo[smaller];
		}

		int s = smaller >> 1; // divide by 2
		int side1 = minProductHelper2(s, bigger, memo);
		int side2 = side1;

		if (smaller % 2 == 1) { // if smaller is an odd number
			side2 = minProductHelper2(smaller - s, bigger, memo);
		}

		// cache the result
		memo[smaller] = side1 + side2;

		return memo[smaller];
	}

	/*
	 * simple recursive approach 30 * 45 = 2 * (15 * 45). when odd number eg: 31 *
	 * 45 = 2 * (15 * 45 ) + 45. No need to cache results. O(n) = log(smaller)
	 */
	public int minProduct3(int a, int b) {

		int smaller = a < b ? a : b;
		int bigger = a > b ? a : b;

		return minProductHelper3(smaller, bigger);
	}

	private int minProductHelper3(int smaller, int bigger) {

		if (smaller == 0) {
			return 0;
		}
		if (smaller == 1) {
			return bigger;
		}

		int s = smaller >> 1; // divide by 2
		int midProduct = minProductHelper3(s, bigger);

		if (smaller % 2 == 0) {
			return midProduct + midProduct;
		} else {
			return midProduct + midProduct + bigger;
		}
	}

}
