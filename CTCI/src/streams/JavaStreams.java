/**
 * 
 */
package streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * source : https://www.youtube.com/watch?v=t1-YZ6bF-g0&t=67s
 * 
 * @author Hammad: 10-Jan-2022
 */
public class JavaStreams {

	public static void main(String[] args) {

		// 1. Integer Stream
		System.out.println("Integer stream");
		IntStream //
				.range(1, 10) //
				.forEach(p -> System.out.println(p));
		System.out.println("******************************");

		// 2. Integer stream with skip
		System.out.println("Integer stream with skip");
		IntStream.range(1, 10).skip(5).forEach(System.out::println);
		System.out.println("******************************");

		// 3. Integer stream with sum
		System.out.println("Integer stream with sum");
		System.out.println(IntStream.range(1, 5).sum()); // stream within a System.out.println() function
		System.out.println("******************************");

		// 4. Stream.of, sorted and find First
		System.out.println("Stream.of, sorted and find First");
		Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(System.out::println);
		System.out.println("******************************");

		// stream from an array, sort, filter and print
		System.out.println("stream from an array, sort, filter and print");
		String[] names = { "Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah" };
		Arrays.stream(names) // same as Stream.of(names)
				.filter(p -> p.startsWith("S")).sorted().forEach(System.out::println);
		System.out.println("******************************");

		// 6. average of squares of an int array
		System.out.println("average of squares of an int array");
		Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map(p -> p * p).average().ifPresent(System.out::println);
		System.out.println("******************************");
	}
}
