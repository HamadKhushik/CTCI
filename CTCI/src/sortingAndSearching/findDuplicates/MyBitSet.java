/**
 * 
 */
package sortingAndSearching.findDuplicates;

/**
 * Class to implement a custome bit set class
 * 
 * @author Hammad: 03-Jan-2022
 */
public class MyBitSet {

	int[] bitSet;

	public MyBitSet(int n) {
		bitSet = new int[(n >> 5) + 1];
	}

	public boolean get(int position) {

		int numberIndex = (position >> 5); // divide by 32
		int bitIndex = (position & 0x1f); // mod 32 - this method of mod only applicable for powers of 2
		return ((bitSet[numberIndex] & (1 << bitIndex)) != 0);
	}

	public void set(int position) {

		int numberIndex = (position >> 5);
		int mask = (position & 0x1f);
		bitSet[numberIndex] |= 1 << mask;
	}

}
