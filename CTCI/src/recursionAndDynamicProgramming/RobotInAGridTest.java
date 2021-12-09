/**
 * 
 */
package recursionAndDynamicProgramming;

import static org.junit.Assert.assertEquals;

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
	public void findPathTest() {
		assertEquals(6, test.findPaths(3, 3));
	}

}
