/**
 * 
 */
package lambdaExpressions;

import java.util.Arrays;
import java.util.List;

/**
 * source :
 * https://www.youtube.com/watch?v=suSdjhS03qk&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=24
 * 
 * @author Hammad: 10-Jan-2022
 */
public class StreamsExample1 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Mathew", "Arnold", 39));

		people.stream().filter(p -> p.getLastName().startsWith("C")).forEach(p -> System.out.println(p.getFirstName())); // Conveyer
																															// belt
																															// analogy

		long count = people.stream().filter(p -> p.getLastName().startsWith("C")).count();

		System.out.println(count);

	}
}
