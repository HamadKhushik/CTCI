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
		byte[] bitVector = new byte[(int) (numberOfInts / 8) + 1];

		int index = 0;

		while (index < array.length) {

			int n = array[index];
			System.out.println(n);
			bitVector[n / 8] |= 1 << (n % 8);
			index++;
		}

		for (int i = 0; i < bitVector.length; i++) {
			for (int j = 0; j < 8; j++) {

				if ((bitVector[i] & (1 << j)) == 0) {
					System.out.println("Missing Number is: " + (i * 8 + j));
					return;
				}
			}
		}
		System.out.println("No Missing int found this time");
	}

	public static int[] generateRandomArray() {

		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = (int) (Math.random() * 10);
		}
		return array;
	}

}
