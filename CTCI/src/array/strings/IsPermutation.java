package array.strings;

public class IsPermutation {

	// sliding window approach
	public static boolean permutation(String s1, String s2) {

		int len1 = s1.length();
		int len2 = s2.length();
		// count array for all the 26 alphabets of english
		int[] count = new int[26];

		if (len1 > len2) {
			return false;
		}

		// check if first len1 characters of s2 are a permutation of s1
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}

		// if first len1 characters of s2 are permutation of s2, then all
		// elements of count would be zero
		if (isZero(count)) {
			return true;
		}

		// sliding window loop
		for (int i = len1; i < len2; i++) {
			count[s2.charAt(i) - 'a']--;
			count[s2.charAt(i - len1) - 'a']++;

			if (isZero(count)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isZero(int[] arr) {

		for (int i : arr) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
}
