package array.strings;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RotateImageTest {

	int[][] beforeRotation;
	int[][] beforeRotationSixBySix;
	int[][] afterRotation;
	int[][] afterRotationSixBySix;
	int[][] notSquare;
	int[][] empty;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		beforeRotation = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		afterRotation = new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		beforeRotationSixBySix = new int[][] { { 315, 301, 755, 542, 955, 33 }, { 943, 613, 233, 880, 945, 280 },
				{ 908, 609, 504, 61, 849, 551 }, { 933, 251, 706, 707, 913, 917 }, { 479, 785, 634, 97, 851, 745 },
				{ 472, 348, 104, 645, 17, 273 } };
		afterRotationSixBySix = new int[][] { { 472, 479, 933, 908, 943, 315 }, { 348, 785, 251, 609, 613, 301 },
				{ 104, 634, 706, 504, 233, 755 }, { 645, 97, 707, 61, 880, 542 }, { 17, 851, 913, 849, 945, 955 },
				{ 273, 745, 917, 551, 280, 33 } };
		notSquare = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		empty = new int[0][0];
	}

	@Test
	public void rotateImageTest() {
		RotateImage.rotateImage(beforeRotationSixBySix);
		assertArrayEquals(afterRotationSixBySix, beforeRotationSixBySix);
		RotateImage.rotateImage(beforeRotation);
		assertArrayEquals(afterRotation, beforeRotation);
		RotateImage.rotateImage(notSquare);
		assertArrayEquals(notSquare, notSquare);
		RotateImage.rotateImage(empty);
		assertArrayEquals(empty, empty);
	}

	@Test
	public void rotateImageLayerByLayerTest() {
		RotateImage.rotateImageLayerByLayer(beforeRotationSixBySix);
		assertArrayEquals(afterRotationSixBySix, beforeRotationSixBySix);
		RotateImage.rotateImageLayerByLayer(beforeRotation);
		assertArrayEquals(afterRotation, beforeRotation);
		RotateImage.rotateImageLayerByLayer(notSquare);
		assertArrayEquals(notSquare, notSquare);
		RotateImage.rotateImageLayerByLayer(empty);
		assertArrayEquals(empty, empty);
	}
}
