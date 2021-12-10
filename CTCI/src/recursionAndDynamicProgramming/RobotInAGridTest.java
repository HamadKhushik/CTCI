/**
 * 
 */
package recursionAndDynamicProgramming;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 09-Dec-2021
 */
public class RobotInAGridTest {

	int row = 3;
	int column = 3;
	RobotInAGrid test = new RobotInAGrid();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findPathsTest() {
		System.out.println("findPaths() TEST");
		test.findPaths(row, column);
		System.out.println("************************************\n");
	}

	@Test
	public void findPathsDynamicProgrammingTest() {
		System.out.println("findPathsDynamicProgramming() TEST");
		test.findPathsDynamicProgramming(row, column);
		System.out.println("************************************\n");
	}

}
