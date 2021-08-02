package recursion.marty.stepp;

import java.io.File;

/*
 * Crawls a directory usint recursion and 
 * prints names of all files in that directory
 * and the sub-directories along with indentation
 */
public class Crawl {

	private static void crawl(File file, int indent) {

		// indentation
		for (int i = 0; i < 4 * indent; i++) {
			System.out.print(" ");
		}
		System.out.println(file.getName());
		// recursive case
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File tempFile : files) {
				crawl(tempFile, indent + 1);
			}
		}
	}

	public static void crawl(File file) {
		// this public method hides the 'indentation' detail from the user
		crawl(file, 0);
	}

	public static void main(String[] args) {
		crawl(new File("src\\"));
	}
}
