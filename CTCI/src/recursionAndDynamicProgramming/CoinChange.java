/**
 * 
 */
package recursionAndDynamicProgramming;

/**
 * 8.11 Coins change, implement an algorithm to calculate number of ways of
 * representing n cents using 25, 10, 5 and 1 cent coins
 * 
 * @author Hammad: 17-Dec-2021
 */
public class CoinChange {

	public int makeChange(int total, int[] denoms) {

		return makeChangeHelper(total, denoms, 0);
	}

	private int makeChangeHelper(int total, int[] denoms, int index) {

		int coin = denoms[index];
		if (index == denoms.length - 1) {
			int remaining = total % coin;
			return remaining == 0 ? 1 : 0;
		}

		int ways = 0;

		for (int amount = 0; amount <= total; amount += coin) {
			ways += makeChangeHelper(total - amount, denoms, index + 1);
		}

		return ways;
	}

	// optimised algorithm using Dynamic Programming/memoization
	public int makeChange2(int total, int[] denoms) {

		// map to cache the results
		int[][] map = new int[total + 1][denoms.length];
		return makeChange2(total, denoms, 0, map);
	}

	private int makeChange2(int total, int[] denoms, int index, int[][] map) {

		if (map[total][index] > 0) {
			return map[total][index];
		}

		int coin = denoms[index];
		if (index == denoms.length - 1) {
			int remaining = total % coin;
			return remaining == 0 ? 1 : 0;
		}

		int ways = 0;

		for (int amount = 0; amount <= total; amount += coin) {
			ways += makeChange2(total - amount, denoms, index + 1, map);
		}

		map[total][index] = ways;

		return ways;
	}

}
