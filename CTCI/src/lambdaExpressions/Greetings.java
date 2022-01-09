/**
 * 
 */
package lambdaExpressions;

/**
 * ref : https://www.youtube.com/watch?v=XQL7sPs-FuI
 * 
 * @author Hammad: 08-Jan-2022
 */
@FunctionalInterface
public interface Greetings {

	public void perform();

	default void another() {
		System.out.println("Hello");
	}

}
