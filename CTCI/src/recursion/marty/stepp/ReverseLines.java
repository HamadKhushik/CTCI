package recursion.marty.stepp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReverseLines {

	private static Scanner scanner;

	/*
	 * reads a file, and prints the lines in reverse order using recursion
	 */
	public void reverseLines(Scanner scanner) throws IOException {

		if (scanner.hasNextLine()) {
			// read current line
			String line = scanner.nextLine();
			// recurse for the rest of the lines
			reverseLines(scanner);
			System.out.println(line);
		}
	}

	public static void main(String[] args) throws IOException {
		ReverseLines object = new ReverseLines();
		File file = new File("src\\recursion\\marty\\stepp\\testFile.txt");

		try {
			Scanner s = new Scanner(file);
			object.reverseLines(s);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
