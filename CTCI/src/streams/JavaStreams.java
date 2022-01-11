/**
 * 
 */
package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * source : https://www.youtube.com/watch?v=t1-YZ6bF-g0&t=67s
 * 
 * @author Hammad: 10-Jan-2022
 */
public class JavaStreams {

	public static void main(String[] args) throws IOException {

		// 1. Integer Stream
		System.out.println("/* Integer stream */");
		IntStream //
				.range(1, 10) //
				.forEach(p -> System.out.println(p));
		System.out.println("******************************\n");

		// 2. Integer stream with skip
		System.out.println("/* Integer stream with skip */");
		IntStream.range(1, 10)
				.skip(5)
				.forEach(System.out::println);
		System.out.println("******************************\n");

		// 3. Integer stream with sum
		System.out.println("/* Integer stream with sum */");
		System.out.println(IntStream.range(1, 5)
				.sum()); // stream within a System.out.println() function
		System.out.println("******************************\n");

		// 4. Stream.of, sorted and find First
		System.out.println("/* Stream.of, sorted and find First */");
		Stream.of("Ava", "Aneri", "Alberto")
				.sorted().findFirst()
				.ifPresent(System.out::println);
		System.out.println("******************************\n");

		// stream from an array, sort, filter and print
		System.out.println("/* Stream from an array, sort, filter and print */");
		String[] names = { "Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah" };
		Arrays.stream(names) // same as Stream.of(names)
				.filter(p -> p.startsWith("S"))
				.sorted()
				.forEach(System.out::println);
		System.out.println("******************************\n");

		// 6. average of squares of an int array
		System.out.println("/* Average of squares of an int array */");
		Arrays.stream(new int[] { 2, 4, 6, 8, 10 })
				.map(p -> p * p).average()
				.ifPresent(System.out::println);
		System.out.println("******************************\n");

		// 7. Stream from list, filter and print
		System.out.println("/* Stream from list, filter and print */");
		List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
		people.stream()
				.map(String::toLowerCase)
				.filter(x -> x.startsWith("a"))
				.forEach(System.out::println);
		System.out.println("******************************\n");

		// 8. Stream rows from text file, sort filter and print
		System.out.println("/* Stream rows from text file, sort filter and print */");
		Stream<String> bands = Files.lines(Paths.get("data/band.txt"));
		bands
				.sorted()
				.filter(x -> x.length() >= 13)
				.forEach(System.out::println);
		bands.close();
		System.out.println("******************************\n");

		// 9. Stream rows from text file and save to list
		System.out.println("/* Stream rows from text file and save to List");
		List<String> bands2 = Files.lines(Paths.get("data/band.txt"))
				.filter(x -> x.contains("jit"))
				.collect(Collectors.toList());
		// different stream
		bands2.forEach(x -> System.out.println(x));
		System.out.println("******************************\n");

		// 10. Stream rows from CSV file and count
		System.out.println("/* Stream rows from CSV file and count */");
		Stream<String> rows1 = Files.lines(Paths.get("data/streamData.txt"));
		int rowCount = (int) rows1
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.count();
		System.out.println("Row Count = " + rowCount);
		rows1.close();
		System.out.println("******************************\n");

		// 11. Stream rows from CSV file, parse data from rows
		System.out.println("/* Stream rows from CSV file, parse data from rows */");
		Stream<String> rows2 = Files.lines(Paths.get("data/streamData.txt"));
		rows2
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
		rows2.close();
		System.out.println("******************************\n");

		// 12. Stream rows from a CSV file, store fields in HashMap
		System.out.println("/* Stream rows from a CSV file, store fields in HashMap */");
		Stream<String> rows3 = Files.lines(Paths.get("data/streamData.txt"));
		Map<String, Integer> map = new HashMap<String, Integer>();
		map = rows3
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
		rows3.close();

		for (String s : map.keySet()) {
			System.out.println("Key: " + s + " value: " + map.get(s));
		}
		System.out.println("******************************\n");

		// 13. Reduction - sum
		double total = Stream.of(7.3, 1.5, 4.8)
				.reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("Total = " + total);
		System.out.println("******************************\n");

		// 14. Reduction - summary statistics
		System.out.println("Reduction - summary statistics of (7, 2, 19, 88, 73, 4, 10)");
		IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
				.summaryStatistics();
		System.out.println(summary);

	}
}
