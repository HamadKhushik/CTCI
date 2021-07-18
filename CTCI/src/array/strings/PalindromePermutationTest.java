package array.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PalindromePermutationTest {

	String s1;
	String s2;
	String s3;
	String s4;
	String empty;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		s1 = "taco cat";
		s2 = "hammad";
		s3 = "deified";
		s4 = "Radar";
		empty = "";
	}

	@Test
	public void test() {
		assertEquals(true, PalindromePermutation.checkPalindromePermutation(s1));
		assertEquals(false, PalindromePermutation.checkPalindromePermutation(s2));
		assertEquals(true, PalindromePermutation.checkPalindromePermutation(s3));
		assertEquals(true, PalindromePermutation.checkPalindromePermutation(s4));
		assertEquals(false, PalindromePermutation.checkPalindromePermutation(empty));
	}

	@Test
	public void isPermutationOfPalindromeTest() {
		assertEquals(true, PalindromePermutation.isPermutationOfPalindrome(s1));
		assertEquals(false, PalindromePermutation.isPermutationOfPalindrome(s2));
		assertEquals(true, PalindromePermutation.isPermutationOfPalindrome(s3));
		assertEquals(true, PalindromePermutation.isPermutationOfPalindrome(s4));
		assertEquals(false, PalindromePermutation.isPermutationOfPalindrome(empty));
	}
}
