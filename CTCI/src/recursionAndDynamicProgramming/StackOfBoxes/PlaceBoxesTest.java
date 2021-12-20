/**
 * 
 */
package recursionAndDynamicProgramming.StackOfBoxes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hammad: 19-Dec-2021
 */
public class PlaceBoxesTest {

	ArrayList<Box> boxes = new ArrayList<Box>();
	ArrayList<Box> boxes2 = new ArrayList<Box>();

	@Before
	public void setUp() throws Exception {

		boxes.add(new Box(1, 1, 1));
		boxes.add(new Box(2, 2, 2));
		boxes.add(new Box(3, 3, 3));

		boxes2.add(new Box(1, 1, 1));
		boxes2.add(new Box(2, 1, 2));
		boxes2.add(new Box(1, 3, 2));
	}

	@Test
	public void createStackTest() {
		assertEquals(6, PlaceBoxes.createStack(boxes));
		assertEquals(0, PlaceBoxes.createStack(null));
		assertEquals(0, PlaceBoxes.createStack(new ArrayList<Box>()));

		assertEquals(2, PlaceBoxes.createStack(boxes2));
		System.out.println(PlaceBoxes.createStack(boxes));
	}

	@Test
	public void createStack2Test() {
		assertEquals(6, PlaceBoxes.createStack2(boxes));
		assertEquals(0, PlaceBoxes.createStack2(null));
		assertEquals(0, PlaceBoxes.createStack2(new ArrayList<Box>()));

		assertEquals(2, PlaceBoxes.createStack2(boxes2));
		System.out.println(PlaceBoxes.createStack2(boxes));
	}

	@Test
	public void createStack3Test() {
		assertEquals(6, PlaceBoxes.createStack3(boxes));
		assertEquals(0, PlaceBoxes.createStack3(null));
		assertEquals(0, PlaceBoxes.createStack3(new ArrayList<Box>()));

		assertEquals(2, PlaceBoxes.createStack3(boxes2));
		System.out.println(PlaceBoxes.createStack3(boxes));
	}

}
