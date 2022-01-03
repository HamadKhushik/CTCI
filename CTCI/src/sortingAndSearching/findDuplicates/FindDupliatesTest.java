/**
 * 
 */
package sortingAndSearching.findDuplicates;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 03-Jan-2022
 */
public class FindDupliatesTest {

	int[] array = { 1, 2, 3, 4, 5, 6, 7, 7, 7, 8, 8, 9, 10, 10 };
	int[] array2 = new int[50];
	int[] empty = new int[0];
	int[] nullArray;

	@Before
	public void setUp() throws Exception {

		for (int i = 0; i < 50; i++) {
			array2[i] = i + 1;
		}
		array2[48] = 50;
	}

	@Test
	public void test() {
		FindDuplicates.findDuplicates(array);
		FindDuplicates.findDuplicates(array2);
		FindDuplicates.findDuplicates(empty);
		FindDuplicates.findDuplicates(nullArray);
	}

}
