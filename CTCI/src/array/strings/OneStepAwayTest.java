package array.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OneStepAwayTest {

	String s1;
	String s2;
	String s3;
	String s4;
	String s5;
	String empty;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		s1 = "taco";
		s2 = "tco";
		s3 = "pale";
		s4 = "bale";
		s5 = "bake";
		empty = "";
	}

	@Test
	public void oneStepAwayTest() {
		assertEquals(true, OneStepAway.oneStepAway(s1, s2));
		assertEquals(true, OneStepAway.oneStepAway(s2, s1));
		assertEquals(false, OneStepAway.oneStepAway(s1, s3));
		assertEquals(true, OneStepAway.oneStepAway(s3, s4));
		assertEquals(false, OneStepAway.oneStepAway(s3, s5));
		assertEquals(false, OneStepAway.oneStepAway(s3, empty));
	}

	@Test
	public void oneAwayTest() {
		assertEquals(true, OneStepAway.oneAway(s1, s2));
		assertEquals(true, OneStepAway.oneAway(s2, s1));
		assertEquals(false, OneStepAway.oneAway(s1, s3));
		assertEquals(true, OneStepAway.oneAway(s3, s4));
		assertEquals(false, OneStepAway.oneAway(s3, s5));
		assertEquals(false, OneStepAway.oneAway(s3, empty));
	}

}
