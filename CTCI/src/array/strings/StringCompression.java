package array.strings;

public class StringCompression {

	public static String compressString(String str) {

		int count = 0;
		StringBuilder compressed = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			count++;

			if ((i + 1) >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(count);
				count = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}

	// optimised solution, where we find the length of the compressed string first
	// and return if original string is shorter than compressed string

	public static String compressStringOptimised(String str) {

		int finalLength = findCompressedLength(str);
		if (finalLength >= str.length()) {
			return str;
		}

		int count = 0;
		StringBuilder compressed = new StringBuilder(finalLength);

		for (int i = 0; i < str.length(); i++) {
			count++;

			if ((i + 1) >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(count);
				count = 0;
			}
		}
		return compressed.toString();
	}

	private static int findCompressedLength(String str) {

		int count = 0;
		int compressedLength = 0;

		for (int i = 0; i < str.length(); i++) {
			count++;

			if ((i + 1) >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(count).length();
				count = 0;
			}
		}
		return compressedLength;
	}
}
