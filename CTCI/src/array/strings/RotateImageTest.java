package array.strings;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RotateImageTest {

	int[][] beforeRotation;
	int[][] afterRotation;
	int[][] notSquare;
	int[][] empty;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		beforeRotation = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		afterRotation = new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		notSquare = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		empty = new int[0][0];
	}

	@Test
	public void rotateImageTest() {
		RotateImage.rotateImage(beforeRotation);
		assertArrayEquals(afterRotation, beforeRotation);
		RotateImage.rotateImage(notSquare);
		assertArrayEquals(notSquare, notSquare);
		RotateImage.rotateImage(empty);
		assertArrayEquals(empty, empty);
	}

}
