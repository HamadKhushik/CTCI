/**
 * 
 */
package sortingAndSearching.groupAnagrams;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Hammad: 27-Dec-2021
 */
public class AnagramComparator implements Comparator<String> {

	public String sortString(String s) {

		char[] content = s.toCharArray();
		Arrays.sort(content);

		return new String(content);
	}

	@Override
	public int compare(String str1, String str2) {
		return sortString(str1).compareTo(sortString(str2));
	}

}
