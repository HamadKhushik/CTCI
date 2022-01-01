/**
 * 
 */
package sortingAndSearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 10.7. with a file of 4 billion non-negative integers, find the missing
 * integer in the file. instead of a file, an array of 10000 non negative random
 * numbers is created.
 * 
 * @author Hammad: 30-Dec-2021
 */
public class MissingInt {

	// a random array is generated to find the missing elements, may contain
	// duplicates
	// @param 'n' = number of random integers to be generated
	public static void findMissing(int n) {

		int[] array = generateRandomArray(n);
		int numberOfInts = n;
		byte[] bitVector = new byte[(int) (numberOfInts / 8) + 1]; // adding +1 since we are not allocating space for
																	// all the
																	// possible non-negative integers

		int index = 0;

		while (index < array.length) {

			int value = array[index];
			System.out.print(value + " ");
			bitVector[value / 8] |= 1 << (value % 8);
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
		array = new int[] { 0, 1, 3, 4, 5, 6 };

		int acc = 0;
		int counter = 2;
		for (int i : array) {
			acc ^= counter ^ i;
			counter++;
		}
		return acc ^ 1;
	}

	public static int[] generateRandomArray(int n) {

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * n);
		}
		return array;
	}

	// solution if the file is bigger than what can be accommodated in the memory
	// based on two passes, first pass to find the missing block and second pass to
	// find the missing number using bit Vector
	public static int findMissing(File filename) throws FileNotFoundException {

		int range = 100; // Integer.MAX_VALUE / 1 << 20;
		try {
			Scanner sc = new Scanner(new FileReader("data/input2.txt"));
			for (int i = 0; i > 10; i++) {
				System.out.println(sc.nextInt());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int[] blocks = getCounterBlocks(filename, range);
		int blockIndex = findMissingBlock(blocks, range);
		byte[] bitVector = createBitVector(filename, blockIndex, range);
		int offset = findZero(bitVector);
		if (offset < 0) {
			return -1;
		}
		return blockIndex * range + offset;
	}

	private static int[] getCounterBlocks(File filename, int range) throws FileNotFoundException {

		int arraySize = 1000 / range + 1;
		int[] blocks = new int[arraySize];

		Scanner sc = new Scanner(new FileReader(filename));

		while (sc.hasNextInt()) {
			int value = sc.nextInt();
			blocks[value / range]++;
		}
		sc.close();
		return blocks;
	}

	private static int findMissingBlock(int[] blocks, int rangeSize) {

		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] < rangeSize) {
				return i;
			}
		}
		return -1;
	}

	private static byte[] createBitVector(File filename, int blockIndex, int rangeSize) throws FileNotFoundException {

		int startingRange = blockIndex * rangeSize;
		int endRange = startingRange + rangeSize;

		byte[] bitVector = new byte[rangeSize / Byte.SIZE + 1];

		Scanner sc = new Scanner(new FileReader(filename));

		while (sc.hasNextInt()) {

			int value = sc.nextInt();
			if (startingRange <= value && value < endRange) {
				int offset = value - startingRange;
				int mask = (1 << (offset % Byte.SIZE));
				bitVector[offset / Byte.SIZE] |= mask;
			}
		}
		sc.close();
		return bitVector;
	}

	private static int findZero(byte[] bitVector) {

		for (int i = 0; i < bitVector.length; i++) {
			if (bitVector[i] != ~0) { // if not all 1's, '~' is the invert operator
				int bitIndex = findZero(bitVector[i]);
				return i * Byte.SIZE + bitIndex;
			}
		}
		return -1;
	}

	private static int findZero(byte b) {

		for (int i = 0; i < Byte.SIZE; i++) {
			int mask = 1 << i;
			if ((b & mask) == 0) {
				return i;
			}
		}
		return -1;
	}

//	public static void main(String[] args) {
//
//		try {
//			FileWriter writer = new FileWriter("C:\\Users\\Hammad\\git\\CTCI\\CTCI\\data\\input2.txt");
//			for (int i = 0; i < 1001; i++) {
//				writer.write(i + "\n");
//			}
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
}
