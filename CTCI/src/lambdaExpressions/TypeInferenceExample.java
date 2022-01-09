/**
 * 
 */
package lambdaExpressions;

/**
 * ref : https://www.youtube.com/watch?v=XQL7sPs-FuI
 * 
 * @author Hammad: 08-Jan-2022
 */
public class TypeInferenceExample {

	public static void main(String[] args) {

		StringLengthLambda myLambda = s -> s.length();
		System.out.println(myLambda.getLength("Hello World"));

		printLambda(s -> s.length());
	}

	public static void printLambda(StringLengthLambda l) {
		System.out.println(l.getLength("Hello World!"));
	}

	interface StringLengthLambda {
		int getLength(String s);
	}

}
