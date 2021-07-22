package array.strings;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ZeroMatrixTest {

	int[][] beforeZeroes;
	int[][] beforeZeroesSixBySix;
	int[][] afterZeroes;
	int[][] afterZeroesSixBySix;
	int[][] notSquare;
	int[][] empty;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		beforeZeroes = new int[][] { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
		afterZeroes = new int[][] { { 1, 0, 3 }, { 0, 0, 0 }, { 7, 0, 9 } };
		beforeZeroesSixBySix = new int[][] { { 0, 301, 755, 542, 955, 33 }, { 943, 613, 233, 880, 945, 280 },
				{ 908, 609, 504, 61, 849, 551 }, { 933, 251, 706, 707, 913, 917 }, { 479, 785, 634, 97, 851, 745 },
				{ 472, 348, 104, 645, 17, 0 } };
		afterZeroesSixBySix = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 613, 233, 880, 945, 0 },
				{ 0, 609, 504, 61, 849, 0 }, { 0, 251, 706, 707, 913, 0 }, { 0, 785, 634, 97, 851, 0 },
				{ 0, 0, 0, 0, 0, 0 } };
		notSquare = new int[][] { { 0, 2, 3 }, { 4, 5, 6 } };
		empty = new int[0][0];
	}

	@Test
	public void setZeroesTest() {
		ZeroMatrix.setZeroes(beforeZeroes);
		assertArrayEquals(afterZeroes, beforeZeroes);
		ZeroMatrix.setZeroes(beforeZeroesSixBySix);
		assertArrayEquals(afterZeroesSixBySix, beforeZeroesSixBySix);
		ZeroMatrix.setZeroes(notSquare);
		assertArrayEquals(new int[][] { { 0, 0, 0 }, { 0, 5, 6 } }, notSquare);
		ZeroMatrix.setZeroes(empty);
		assertArrayEquals(empty, empty);
	}

}
