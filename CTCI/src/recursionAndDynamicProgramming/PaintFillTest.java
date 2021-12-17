/**
 * 
 */
package recursionAndDynamicProgramming;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 16-Dec-2021
 */
public class PaintFillTest {

	PaintFill.Color[][] array = { { PaintFill.Color.BLACK, PaintFill.Color.BLACK, PaintFill.Color.BLACK },
			{ PaintFill.Color.BLACK, PaintFill.Color.BLACK, PaintFill.Color.GREEN },
			{ PaintFill.Color.WHITE, PaintFill.Color.BLACK, PaintFill.Color.GREEN } };

	PaintFill testObject = new PaintFill();

	PaintFill.Color[][] expected = { { PaintFill.Color.RED, PaintFill.Color.RED, PaintFill.Color.RED },
			{ PaintFill.Color.RED, PaintFill.Color.RED, PaintFill.Color.GREEN },
			{ PaintFill.Color.WHITE, PaintFill.Color.RED, PaintFill.Color.GREEN } };

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		testObject.fill(array, 1, 1, PaintFill.Color.RED);
		System.out.println(Arrays.deepToString(array));
		assertArrayEquals(expected, array);
		testObject.fill(array, 2, 2, PaintFill.Color.BLACK);
		System.out.println(Arrays.deepToString(array));
		testObject.fill(array, 2, 0, PaintFill.Color.YELLOW);
		System.out.println(Arrays.deepToString(array));
	}

}
