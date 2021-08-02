package recursion.marty.stepp;

/*
 * calculate the power of a number using recursion
 * cant handle -ve exponents
 */

public class CalculateExponent {

	public static int power(int base, int exp) {

		if (exp < 0) {
			return 0;
		}
		// base case
		if (exp == 0) {
			return 1;
		} else {
			// recursive case
			return base * power(base, exp - 1);
		}
	}
}
