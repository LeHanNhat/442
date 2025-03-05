package lab2.q2;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import lab1q1.CircleRadius;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("DKK", DKK.getName());
		assertEquals("SEK", SEK.getName());
		assertEquals("SweBank", SweBank.getName());
		assertEquals("Nordea", Nordea.getName());
		assertEquals("DanskeBank", DanskeBank.getName());
		
	}

	@Test
	public void testGetCurrency() {
		
		assertEquals(SEK, SweBank.getCurrency());
		assertEquals(SEK, Nordea.getCurrency());
		assertEquals(DKK, DanskeBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		 assertDoesNotThrow(() -> {
			 SweBank.openAccount("Ulrika");
	        },"No exception should be thrown when account does not exist.");
		
		
	}
//
//	@Test
//	public void testDeposit() throws AccountDoesNotExistException {
//		fail("Write test case here");
//	}
//
//	@Test
//	public void testWithdraw() throws AccountDoesNotExistException {
//		fail("Write test case here");
//	}
//	
//	@Test
//	public void testGetBalance() throws AccountDoesNotExistException {
//		fail("Write test case here");
//	}
//	
//	@Test
//	public void testTransfer() throws AccountDoesNotExistException {
//		fail("Write test case here");
//	}
//	
//	@Test
//	public void testTimedPayment() throws AccountDoesNotExistException {
//		fail("Write test case here");
//	}
}
