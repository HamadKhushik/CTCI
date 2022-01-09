/**
 * 
 */
package lambdaExpressions;

import java.util.function.BiConsumer;

/**
 * @author Hammad: 09-Jan-2022
 */
public class ExceptionalHandlingExample {

	public static void main(String[] args) {
		int[] someNumber = { 1, 2, 3, 4 };
		int key = 0;

		// System.out.println(value + key
		process(someNumber, key, wrapperLambda((value, k) -> System.out.println(value / k)));

	}

	private static void process(int[] someNumber, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumber) {
			consumer.accept(i, key);
		}
	}

	// just a wrapper method to handle the exception neatly
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (value, k) -> {
			try {
				System.out.println(value / k);
			} catch (ArithmeticException e) {
				System.out.println("Arithmetic Exception caught");
			}
		};
	}

}
