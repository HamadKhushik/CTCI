package array.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class URLifyTest {

	String s1;
	String s2;
	String s3;
	String s4;
	String s5;

	char[] c1;
	char[] c2;
	char[] c3;
	char[] c4;
	char[] c5;

	@Before
	public void setUp() throws Exception {

		s1 = "";
		s2 = "ab cde   ghij        ";
		s3 = "abc def ghi    ";
		s4 = "abc%20def%20ghi";
		s5 = "ab%20cde%20%20%20ghij";
		c1 = s1.toCharArray();
		c2 = s2.toCharArray();
		c3 = s3.toCharArray();
		c4 = s4.toCharArray();
		c5 = s5.toCharArray();
	}

	@Test
	public void replaceSpacesTest() {
		URLify.replaceSpaces(c3, 11);
		Assert.assertArrayEquals(c4, c3);
		URLify.replaceSpaces(c2, 13);
		Assert.assertArrayEquals(c5, c2);
		URLify.replaceSpaces(c1, 0);
		Assert.assertArrayEquals(c1, c1);
	}

	@Test
	public void urlifyTest() {
		Assert.assertArrayEquals(c4, URLify.urlify(c3, 11));
		Assert.assertArrayEquals(c5, URLify.urlify(c2, 13));
		Assert.assertArrayEquals(c1, URLify.urlify(c1, 0));
	}

	@Test
	public void urlifySBTest() {
		assertEquals(s4, URLify.urlifySB(s3));
		assertEquals(s5, URLify.urlifySB(s2));
		assertEquals("", URLify.urlifySB(s1));
	}

}
