package sortingAndSearching.findDuplicates;

/**
 * 10.8 find duplicates in an array with all the numbers from 1 to 'n' where n
 * is at most 32000. array may contain duplicates. assume there is only
 * 4kilobytes of memory available.
 * 
 * BitSet Class has been implemented for this.
 * 
 * @author Hammad: 02-Jan-2022
 */
public class FindDuplicates {

	public static void findDuplicates(int[] array) {

		if (array == null || array.length <= 1) {
			return;
		}

		MyBitSet bitVector = new MyBitSet(32000);

		for (int i = 0; i < array.length; i++) {

			int num = array[i];
			int num0 = num - 1; // since array starts from 1 and bit vector starts from 0
			if (bitVector.get(num0)) {
				System.out.println(num);
			} else {
				bitVector.set(num0);
			}
		}
	}
}
