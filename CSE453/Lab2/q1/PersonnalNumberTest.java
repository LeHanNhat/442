package lab2.q1;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import test.ContactManager;



class PersonnalNumberTest {
	
	private PersonnalNumber pan;
	private PersonnalNumber pan1;

	@BeforeEach
	void setUp() throws Exception {
		pan=new PersonnalNumber("640823-3234");
		
		pan.initializeMonth();
	}
	
	@Test
	void testGetYear() {
		
		assertEquals(1964,pan.getYear());
	}
	
	@Test
	void testChecksum() {
		
		assertEquals(true,pan.checkCheckSumDigit());
	}
	@Test
	void testGetMonth() {
		
		assertEquals("August",pan.getMonth());
	}
	@Test
	void testGetSex() {
		
		assertEquals("Male",pan.getSex());
	}
	@Test
	void testGetDate() {
		
		assertEquals("23-August-1964",pan.getDate());
	}
}
