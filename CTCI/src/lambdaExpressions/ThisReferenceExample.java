/**
 * 
 */
package lambdaExpressions;

/**
 * source :
 * https://www.youtube.com/watch?v=x9ovGHK7r2E&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=20
 * 
 * @author Hammad: 09-Jan-2022
 */
public class ThisReferenceExample {

	public void doProcess(int i, Process p) {
		p.process(i);
	}

	public void execute() {
		doProcess(10, i -> {
			System.out.println("in execute method, this is the value of i: " + i);
			System.out.println(this);
		});
	}

	public String toString() {
		return "this is an instance of ThisReferenceExample";
	}

	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

//		thisReferenceExample.doProcess(10, new Process() {
//
//			@Override
//			public void process(int i) {
//				System.out.println("the value of i is : " + i);
//				System.out.println(this); // 'this' here refers to object of anonymous inner class object
//			}
//
//			@Override
//			public String toString() {
//				return "this is an instance of anonymous inner class";
//			}
//
//		});

		thisReferenceExample.doProcess(10, i -> {

			System.out.println("the value of i in lambda expression is: " + i);
			// lambda expression does not override 'this' - reference
//			System.out.println(this);  // lambda expression will not change the value of 'this' reference - it would still point to the calling object, which in static method will be invalid

		});

		thisReferenceExample.execute();

	}
}
