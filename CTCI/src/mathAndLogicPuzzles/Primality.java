package mathAndLogicPuzzles;

/*
 * Math And Logic Puzzles
 * check if a number is prime number or not
 */
public class Primality {

	public boolean isPrime(int number) {

		// 0 and 1 are not prime numbers
		if (number < 2) {
			return false;
		}

		for (int i = 2; i < number; i++) {

			// if number is divisible by any other number except itself and '1' - its not
			// prime
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Sieve of Eratosthenes - generates all the prime numbers between '0' and the
	 * given number
	 */
	public boolean[] sieveOfEratosthenes(int number) {

		boolean[] flags = new boolean[number + 1];
		initFlags(flags);

		int prime = 2;

		while (prime < Math.sqrt(number)) {
			crossOff(flags, prime);
			prime = findNextPrime(flags, prime);
		}
		return flags;
	}

	// set all the multiples of prime to false in the flags[]
	public void crossOff(boolean[] flags, int prime) {

		for (int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}

	// find the next prime in flags[]
	public int findNextPrime(boolean[] flags, int prime) {

		int next = prime + 1;

		while (next < flags.length && !flags[next]) {
			next++;
		}
		return next;
	}

	// initialize all flags to true except '0' and '1'
	public void initFlags(boolean[] flags) {

		for (int i = 2; i < flags.length; i++) {
			flags[i] = true;
		}
	}
}
