package lambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ref : https://www.youtube.com/watch?v=XQL7sPs-FuI
 * 
 * @author Hammad: 09-Jan-2022
 */
public class Exercise {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Mathew", "Arnold", 39));

		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person a, Person b) {
				return a.getLastName().compareTo(b.getLastName());
			}
		});

		// create a method to print all the names of the persons
		printAllPeople(people);

		// print all the people with last name beginning with 'C'
		printConditionally(people, new Condition() { // anonymous inner class to implement the Condition interface

			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});

		// print all people with first name beginning with 'c'
		printConditionally(people, new Condition() { // different instance of Condition interface with different
														// condition

			@Override
			public boolean test(Person p) {
				return p.getFirstName().startsWith("C");
			}
		});
	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}

	public static void printAllPeople(List<Person> people) {

		for (Person p : people) {
			System.out.println(p);
		}
	}
}

interface Condition {
	boolean test(Person p);
}