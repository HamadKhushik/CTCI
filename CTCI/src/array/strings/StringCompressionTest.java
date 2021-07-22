package array.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringCompressionTest {

	String s1 = "aabbbccccccaa";
	String s2 = "abcd";
	String s3 = "AAAAaaagh";
	String s4 = "AaBbCcDd";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void compressStringTest() {
		assertEquals("a2b3c6a2", StringCompression.compressString(s1));
		assertEquals(s2, StringCompression.compressString(s2));
		assertEquals("A4a3g1h1", StringCompression.compressString(s3));
		assertEquals(s4, StringCompression.compressString(s4));
	}

	@Test
	public void compressStringOptimisedTest() {
		assertEquals("a2b3c6a2", StringCompression.compressStringOptimised(s1));
		assertEquals(s2, StringCompression.compressStringOptimised(s2));
		assertEquals("A4a3g1h1", StringCompression.compressStringOptimised(s3));
		assertEquals(s4, StringCompression.compressStringOptimised(s4));
	}

}
