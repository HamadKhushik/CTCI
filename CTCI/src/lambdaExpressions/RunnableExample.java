/**
 * 
 */
package lambdaExpressions;

/**
 * ref : https://www.youtube.com/watch?v=XQL7sPs-FuI
 * 
 * @author Hammad: 09-Jan-2022
 */
public class RunnableExample {

	public static void main(String[] args) {
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Printed inside runnable");
			}
		});

		myThread.run();

		Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside lambda runnable"));
		myLambdaThread.run();

	}

}
