package lab1q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RomantoIntegerTest {

	@Test
	void testSingleDigit() {
		RomantoInteger romanto = new RomantoInteger();
		assertEquals(5, romanto.convert("V"));
		assertEquals(1, romanto.convert("I"));
	}
	@Test
	void testMultipleDigit() {
		RomantoInteger romanto = new RomantoInteger();
		assertEquals(2, romanto.convert("II"));
		assertEquals(3, romanto.convert("III"));
	}
	@Test
	void testDifferentDigit() {
		RomantoInteger romanto = new RomantoInteger();
		assertEquals(6, romanto.convert("VI"));
		assertEquals(16, romanto.convert("XVI"));
	}
	@Test
	void testSubtractiveNotation() {
		RomantoInteger romanto = new RomantoInteger();
		assertEquals(6, romanto.convert("VI"));
		assertEquals(16, romanto.convert("XVI"));
	}
	@Test
	void testDigitAndSubtractiveNotation() {
		RomantoInteger romanto = new RomantoInteger();
		assertEquals(19, romanto.convert("XIX"));
	}
	@Test
	void testInvalidNumber() {
		RomantoInteger romanto = new RomantoInteger();
		assertEquals(-1, romanto.convert("VX"));
		assertEquals(-1, romanto.convert("XXC"));
	}
}
