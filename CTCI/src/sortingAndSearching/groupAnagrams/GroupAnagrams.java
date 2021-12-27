/**
 * 
 */
package sortingAndSearching.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 10.2 sort an array of strings such that all the anagrams in the array appear
 * together
 * 
 * @author Hammad: 27-Dec-2021
 */
public class GroupAnagrams {

	/**
	 * sorts the array using modified comparator, sorts the strings first and then
	 * compares the sorted strings. sorted strings of anagrams will be the same and
	 * hence grouped together. time complexity O(nlogn * slogs) where 'n' is the
	 * length of the array and 's' is the length of the longest string in the array.
	 */
	public static void groupAnagrams(String[] array) {

		if (array == null) {
			return;
		}
		Arrays.sort(array, new AnagramComparator());
	}

	/**
	 * groups anagrams together by using a Hashmap to store sorted string as keys
	 * and their anagrams present in the array as values in a list of strings. then
	 * we convert the map to a string array. time complexity O(n * slogs) where 'n'
	 * is the length of the array and 's' is the length of the longest string
	 * present in the array.
	 * 
	 * slogs is the time to sort a string of length 's' and we are sorting all the
	 * strings in the array
	 */
	public static void groupAnagramsUsingMap(String[] array) {

		if (array == null) {
			return;
		}

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (String k : array) {
			String key = sort(k);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(k);
		}

		int index = 0;
		for (String j : map.keySet()) {
			ArrayList<String> list = map.get(j);
			for (String curr : list) {
				array[index] = curr;
				index++;
			}
		}
	}

	/**
	 * sorts the string by creating a char array and then sorting it using
	 * Arrays.sort() method
	 */
	private static String sort(String s) {

		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

}
