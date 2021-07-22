package array.strings;

public class IsStringRotation {

	/*
	 * youtube solution using .indexOf() method, simple and readable code O(n)
	 * runtime and O(n) space
	 */
	public static boolean isRotation(String s1, String s2) {

		if (s1.length() == 0 || s1.length() != s2.length()) {
			return false;
		}

		return (s1 + s1).indexOf(s2) > -1;
	}

	public static boolean isRotation2(String s1, String s2) {

		int len = s1.length();

		if (len == 0 || len != s2.length()) {
			return false;
		}
		String s1s1 = s1 + s1;

		return isSubString(s1s1, s2);
	}

	private static boolean isSubString(String str1, String str2) {

		return str1.contains(str2);
	}

}
