package array.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IsPermutationTest {

	String s1;
	String s2;
	String s3;
	String s4;

	@Before
	public void setUp() throws Exception {
		s1 = "ab";
		s2 = "eidbaoo";
		s3 = "eidboao";
		s4 = "eidb";
	}

	@Test
	public void permutationTest() {
		assertEquals(true, IsPermutation.permutation(s1, s2));
		assertEquals(false, IsPermutation.permutation(s1, s3));
		assertEquals(true, IsPermutation.permutation(s4, s2));
	}

}
