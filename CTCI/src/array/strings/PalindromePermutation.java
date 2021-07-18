package array.strings;

public class PalindromePermutation {

	// my solution using char[]
	public static boolean checkPalindromePermutation(String str) {

		if (str.length() < 1) {
			return false;
		}

		// ignoring case sensitivity
		str = str.toLowerCase();
		int[] array = new int[26];
		int spaceCount = 0;

		for (char ch : str.toCharArray()) {
			if (ch != ' ') {
				int index = ch - 'a';
				array[index]++;
			} else {
				spaceCount++;
			}
		}

		boolean flag = false;

		for (int i = 0; i < 26; i++) {

			// if string length is even, every character must have even
			// even number of occurrences
			if ((str.length() - spaceCount) % 2 == 0) {
				if (array[i] % 2 > 0) {
					return false;
				}
			}
			// if string length is odd, every character must have even
			// occurrences except one
			if ((str.length() - spaceCount) % 2 == 1) {

				if (array[i] % 2 > 0 && flag) {
					return false;
				} else if (array[i] % 2 > 0 && !flag) {
					flag = true;
				}
			}
		}

		return true;
	}

	// solution in the book
	// using only one loop, checking permutation Palindrome as we go along
	public static boolean isPermutationOfPalindrome(String str) {

		if (str.length() < 1) {
			return false;
		}

		str = str.toLowerCase(); // Assumption - only lower case letters
		int characterCount = 26; // Assumption - only 'a' to 'z' characters

		// to keep track number of characters as we go along
		int isOdd = 0;
		int[] result = new int[characterCount];

		for (char ch : str.toCharArray()) {
			int index = ch - 'a';
			if (index >= 0 && index < characterCount) {
				result[index]++;
				if (result[index] % 2 == 1) {
					isOdd++;
				} else {
					isOdd--;
				}
			}

		}
		return isOdd <= 1;
	}

	public static boolean checkPalindromPermutationBitVector(String str) {

		return false;
	}

}
