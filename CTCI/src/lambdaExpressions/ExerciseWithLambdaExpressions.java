/**
 * 
 */
package lambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * ref : https://www.youtube.com/watch?v=XQL7sPs-FuI
 * 
 * @author Hammad: 09-Jan-2022
 */
public class ExerciseWithLambdaExpressions {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Mathew", "Arnold", 39));

		// sort list by last name
		Collections.sort(people, (Person a, Person b) -> a.getLastName().compareTo(b.getLastName()));

		// print all the names in the list
//		printAllNames(people);
		printConditionally(people, p -> true, p -> System.out.println(p)); // lambda expression which is true for all
																			// the conditions, same as print
		// all names

		// print all names starting with 'C'
		printConditionally(people, (Person p) -> p.getLastName().startsWith("C"),
				(Person p) -> System.out.println(p.getFirstName()));
	}

	private static void printConditionally(List<Person> people, Predicate<Person> predicate,
			Consumer<Person> consumer) { // interface Condition
		// implemented in Exercise.java class replaced with java.util functional
		// interface

		for (Person p : people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}

	}

	// not required anymore as printConditionally is supplied with a lambda function
	// which is always true
	// private static void printAllNames(List<Person> people) {
//
//		for (Person p : people) {
//			System.out.println(p);
//		}
//	}

}
