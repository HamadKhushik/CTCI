package array.strings;

import java.util.HashMap;

public class IsUniqueString {

	// check if every character in the string is unique
	public static boolean isUnique(String toCheck) {

		// ASCII has only 128 characters, so if string length is larger than this,
		// it must have some duplicate characters
		// it reduces the running time to almost constant i-e 128!!
		if (toCheck.length() > 128) {
			return false;
		}

		for (int i = 0; i < toCheck.length(); i++) {

			if (toCheck.indexOf(toCheck.charAt(i), i + 1) > 0) {
				return false;
			}
		}
		return true;
	}

	// solution using the boolean array for ASCII characters
	public static boolean isUniqueBooleanArray(String toCheck) {

		// ASCII has only 128 characters, so if string length is larger than this,
		// it must have some duplicate characters
		if (toCheck.length() > 128) {
			return false;
		}
		boolean[] arr = new boolean[128];

		for (char ch : toCheck.toCharArray()) {

			int index = (int) ch;
			if (arr[index] == true) {
				return false;
			}
			arr[index] = true;
		}
		return true;
	}

	// solution using a Map
	// Map is not really necessary, SET would be a better option
	public static boolean isUniqueMap(String toCheck) {

		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();

		for (Character ch : toCheck.toCharArray()) {

			if (map.containsKey(ch)) {
				return false;
			}
			map.put(ch, true);
		}
		return true;
	}

	public static boolean isUniqueBitVector(String toCheck) {

		int index = 0;
		int[] arr = new int[4];

		for (char ch : toCheck.toCharArray()) {
			int bitSet = 1 << (int) ch % 32;
			index = (int) ch >> 5;

			if ((arr[index] & bitSet) > 0) {
				return false;
			}
			arr[index] |= bitSet;
		}

		return true;
	}

}
