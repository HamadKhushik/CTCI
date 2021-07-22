package array.strings;

public class OneStepAway {

	public static boolean oneStepAway(String str1, String str2) {

		int lengthComparision = str1.length() - str2.length();
		switch (lengthComparision) {

		case 0:
			return oneEdit(str1, str2);

		case 1:
			return oneInsertion(str2, str1);

		case -1:
			return oneInsertion(str1, str2);
		}
		return false;
	}

	private static boolean oneEdit(String str1, String str2) {

		boolean editFlag = false;
		for (int i = 0; i < str1.length(); i++) {

			if (str1.charAt(i) != str2.charAt(i)) {
				if (editFlag) {
					return false;
				}
				editFlag = true;
			}
		}
		return true;
	}

	private static boolean oneInsertion(String str1, String str2) {

		int index1 = 0;
		int index2 = 0;

		while (index1 < str1.length() && index2 < str2.length()) {

			if (str1.charAt(index1) != str2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	// solution using a single loop, merging insert, replace and delete in one loop
	public static boolean oneAway(String str1, String str2) {

		// check string lengths
		if (Math.abs(str1.length() - str2.length()) > 1) {
			return false;
		}

		// Assign shorter and longer Strings
		String s1 = str1.length() < str2.length() ? str1 : str2;
		String s2 = str1.length() < str2.length() ? str2 : str1;

		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;

		while (index1 < str1.length() && index2 < str2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (foundDifference) {
					return false;
				}

				foundDifference = true;

				// if replaed, move the shorter pointer
				if (s1.length() == s2.length()) {
					index1++;
				}
			} else { // if characters are same, move the shorter pointer
				index1++;
			}
			index2++; // always move pointer for longer string
		}
		return true;
	}

	// Conditional operator
//	public static void main(String[] args) {
//		String first = "abcde";
//		String second = "abcd";
//
//		String s1 = first.length() < second.length() ? first : second;
//		String s2 = first.length() < second.length() ? second : first;
//		System.out.println(s1);
//		System.out.println(s2);
//	}

}
