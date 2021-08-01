package recursion.marty.stepp;

/*
 * Marty Stepp lectures on Recursion
 * Print BInary method which converts a decimal number into binary
 * through recursion
 * No loops or Data Structures allowed
 * 
 * eg convert 43 to binary
 * 43 = 101011
 * lastDigit = 43 % 2 = 1
 * restoFDigit = 43/2 = 21 = 10101
 */

public class PrintBinary {

	// takes an int as argument and prints its binary via recursion
	public void printBinary(int n) {

		// extra base case to handle -ve numbers
		if (n < 0) {
			System.out.print("-");
			printBinary(-n);
		}
		// base case, easy case
		else if (n < 2) {
			System.out.print(n);
		} else {
			// recursive case
			int lastDigit = n % 2; //
			int restOfDigit = n / 2;
			printBinary(restOfDigit);
			System.out.print(lastDigit);
		}
	}

	public static void main(String[] args) {
		PrintBinary x = new PrintBinary();
		System.out.print("PrintBinary 43 = ");
		x.printBinary(43);
		System.out.print("\nPrint Binary 0 = ");
		x.printBinary(0);
		System.out.print("\nPrint Binary 10 = ");
		x.printBinary(10);
		System.out.print("\nPrint Binary 64 = ");
		x.printBinary(64);
		System.out.print("\nPrint Binary 32 = ");
		x.printBinary(32);
		System.out.print("\nPrint Binary -32 = ");
		x.printBinary(-32);
	}
}
