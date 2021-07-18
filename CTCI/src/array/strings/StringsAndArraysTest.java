package array.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringsAndArraysTest {

	String empty;
	String unique;
	String small;
	String large;

	@Before
	public void setUp() throws Exception {

		empty = new String();
		unique = "abcdef";
		small = "aAbBcCdD";
		large = "abdEefgghiIj";
	}

	@Test
	public void isUniqueTest() {

		assertEquals(true, IsUniqueString.isUnique(empty));
		assertEquals(true, IsUniqueString.isUnique(unique));
		assertEquals(true, IsUniqueString.isUnique(small));
		assertEquals(false, IsUniqueString.isUnique(large));
	}

	@Test
	public void isUniqueBooleanArrayTest() {

		assertEquals(true, IsUniqueString.isUniqueBooleanArray(empty));
		assertEquals(true, IsUniqueString.isUniqueBooleanArray(unique));
		assertEquals(true, IsUniqueString.isUniqueBooleanArray(small));
		assertEquals(false, IsUniqueString.isUniqueBooleanArray(large));
	}

	@Test
	public void isUniqueMapTest() {

		assertEquals(true, IsUniqueString.isUniqueMap(empty));
		assertEquals(true, IsUniqueString.isUniqueMap(unique));
		assertEquals(true, IsUniqueString.isUniqueMap(small));
		assertEquals(false, IsUniqueString.isUniqueMap(large));
	}

	@Test
	public void isUniqueBitVectorTest() {

		assertEquals(true, IsUniqueString.isUniqueBitVector(empty));
		assertEquals(true, IsUniqueString.isUniqueBitVector(unique));
		assertEquals(true, IsUniqueString.isUniqueBitVector(small));
		assertEquals(false, IsUniqueString.isUniqueBitVector(large));
	}
}
