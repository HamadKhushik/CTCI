/**
 * 
 */
package sortingAndSearching;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Gayle Laakmans Solution on github
 * 
 * @author Hammad: 31-Dec-2021
 */
public class MissingIntBook {

	public static long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
	public static byte[] bitfield = new byte[(int) (numberOfInts / 8)];

	public static void findOpenNumber() throws IOException {
		Scanner in = new Scanner(new FileReader("data/input.txt"));
		while (in.hasNextInt()) {
			int n = in.nextInt();
			/*
			 * Finds the corresponding number in the bitfield by using the OR operator to
			 * set the nth bit of a byte (e.g., 10 would correspond to bit 2 of index 1 in
			 * the byte array).
			 */
			bitfield[n / 8] |= 1 << (n % 8);
		}

		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				/*
				 * Retrieves the individual bits of each byte. When 0 bit is found, finds the
				 * corresponding value.
				 */
				if ((bitfield[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j);
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		findOpenNumber();
	}
}
