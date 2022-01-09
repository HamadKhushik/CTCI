/**
 * 
 */
package lambdaExpressions;

/**
 * source :
 * https://www.youtube.com/watch?v=WcLum7g6ImU&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=19
 * 
 * @author Hammad: 09-Jan-2022
 */
public class ClosureExample {

	public static void main(String[] args) {

		int a = 10;
		int b = 20; // using an out of scope variable is called closure in lambda expressions

		doProcess(a, i -> System.out.println(i + b)); // since 'b' is out of scope for doProcess(), it must be
														// 'effectively' final to be used
	}

	public static void doProcess(int i, Process p) {

		p.process(i);
	}

}

interface Process {
	void process(int i);
}