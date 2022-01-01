/**
 * 
 */
package sortingAndSearching;

/**
 * 10.7. with a file of 4 billion non-negative integers, find the missing
 * integer in the file. instead of a file, an array of 10000 non negative random
 * numbers is created.
 * 
 * @author Hammad: 30-Dec-2021
 */
public class MissingInt {

	public static void findMissing() {

		int[] array = generateRandomArray();
		int numberOfInts = 10;
		byte[] bitVector = new byte[(int) (numberOfInts / 8) + 1]; // adding +1 since we are not allocating for all the
																	// possible non-negative integers

		int index = 0;

		while (index < array.length) {

			int n = array[index];
			System.out.print(n + " ");
			bitVector[n / 8] |= 1 << (n % 8);
			index++;
		}

		for (int i = 0; i < bitVector.length; i++) {
			for (int j = 0; j < 8; j++) {

				if ((bitVector[i] & (1 << j)) == 0) {
					System.out.println("\n\nMissing Number is: " + (i * 8 + j));
					return;
				}
			}
		}
		System.out.println("No Missing int found this time");
	}

	// solution using Abelion Group
	// source:
	// https://www.reddit.com/r/learnjava/comments/rroj2i/create_a_bit_vector_with_2_billion_bits/hqmcnz9/?context=3
	public static int missingInt2(int[] array) {

		if (array == null || array.length == 0) {
			return -1;
		}

		int acc = 0;
		int counter = 2;
		for (int i : array) {
			acc ^= counter ^ i;
			counter++;
		}
		return acc ^ counter ^ 1;
	}

	public static int[] generateRandomArray() {

		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = (int) (Math.random() * 10);
		}
		return array;
	}
}
