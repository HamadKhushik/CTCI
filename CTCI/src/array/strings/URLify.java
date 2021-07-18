package array.strings;

public class URLify {

	// solution in the book
	// does not use any extra data structure
	// O(1) space solution
	// since array is immutable, we can assume that it has sufficient space at the
	// end
	// to hold the extra characters
	public static void replaceSpaces(char[] str, int actualLength) {

		int spaceLength = countChar(str, 0, actualLength, ' ');
		// since replacing ' ' with '%20' will require 2*space count extra characters
		int newLength = actualLength - 1 + 2 * spaceLength;

		if (newLength < actualLength - 1) {
			str[newLength + 1] = '\0';
		}

		for (int i = actualLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength--] = '0';
				str[newLength--] = '2';
				str[newLength--] = '%';
			} else {
				str[newLength--] = str[i];
			}
		}
	}

	// helper method to count the number of any character in a char[]
	private static int countChar(char[] str, int start, int end, char target) {

		int count = 0;
		for (int i = start; i < end; i++) {
			if (str[i] == target) {
				count++;
			}
		}
		return count;
	}

	// replace every space character with %20
	// solution using a char[]
	// my solution
	public static char[] urlify(char[] str, int actualLength) {

		int spaceCount = 0;
		for (int i = 0; i < actualLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		// since ' ' has to be reaplaced by %20, 2*spaceCount more characters are
		// required for the solution
		char[] result = new char[actualLength + 2 * spaceCount];
		int counter = 0;

		for (int i = 0; i < actualLength; i++) {
			if (str[i] == ' ') {
				result[counter++] = '%';
				result[counter++] = '2';
				result[counter++] = '0';
			} else {
				result[counter++] = str[i];
			}
		}

		return result;
	}

	// solution using String Builder
	public static String urlifySB(String str) {

		str = str.trim();
		int n = str.length();
		StringBuilder result = new StringBuilder();

		for (char ch : str.toCharArray()) {
			if (ch == ' ') {
				result.append("%20");
			} else {
				result.append(ch);
			}
		}

		return result.toString();
	}
}
