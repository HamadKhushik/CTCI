/**
 * 
 */
package lambdaExpressions;

/**
 * source :
 * https://www.youtube.com/watch?v=lwwIZuwYmNI&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=21
 * 
 * @author Hammad: 09-Jan-2022
 */
public class MethodReferenceExample1 {

	public static void main(String[] args) {

//		Thread t = new Thread(() -> printMessage());
		Thread t = new Thread(MethodReferenceExample1::printMessage); // printMessage() is a static method, hence no
																		// object reference involved
		// MethodReferenceExample1::printMessage === () -> printMessage()
		t.start();

	}

	public static void printMessage() {
		System.out.println("Hello");
	}

}
