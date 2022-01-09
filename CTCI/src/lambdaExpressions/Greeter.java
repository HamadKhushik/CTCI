/**
 * 
 */
package lambdaExpressions;

/**
 * ref : https://www.youtube.com/watch?v=XQL7sPs-FuI
 * 
 * @author Hammad: 08-Jan-2022
 */
public class Greeter {

	public void greet(Greetings greetings) {
		greetings.perform();
	}

	public static void main(String[] args) {
		Greeter greeter = new Greeter();

//		Greetings helloWorldGreetings = new HelloWorldGreetings();
		Greetings myLambdaFunction = () -> System.out.println("Hello World");
		Greetings innerClassGreetings = new Greetings() { // anonymous inner class
			public void perform() {
				System.out.println("Hello World");
			}
		};

		innerClassGreetings.perform();
		myLambdaFunction.perform();
		greeter.greet(myLambdaFunction);
		greeter.greet(innerClassGreetings);
	}

}

//interface MyLambda {
//	void foo();
//}
//
//interface MyAdd {
//	int tryAdd(int x, int y);
//}