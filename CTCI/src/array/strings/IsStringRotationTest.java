package array.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IsStringRotationTest {

	String s1;
	String s2;
	String s3;
	String empty;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		s1 = "waterbottle";
		s2 = "WaterBottle";
		s3 = " water bottle";
		empty = "";
	}

	@Test
	public void isRotationTest() {
		assertEquals(true, IsStringRotation.isRotation("erbottlewat", s1));
		assertEquals(true, IsStringRotation.isRotation("erBottleWat", s2));
		assertEquals(true, IsStringRotation.isRotation("er bottle wat", s3));
		assertEquals(false, IsStringRotation.isRotation("", empty));
	}

	@Test
	public void isRotation2Test() {
		assertEquals(true, IsStringRotation.isRotation2("erbottlewat", s1));
		assertEquals(true, IsStringRotation.isRotation2("erBottleWat", s2));
		assertEquals(true, IsStringRotation.isRotation2("er bottle wat", s3));
		assertEquals(false, IsStringRotation.isRotation2("", empty));
	}

}
