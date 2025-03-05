package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class ContactManagerTest {
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Should print before all test");
	}

	@BeforeEach
	public  void setup() {
		System.out.println("Intantiating Contact Manager");
		ContactManager contact = new ContactManager();
	}
	@AfterEach
	public  void tearDown() {
		System.out.println("Should execute before each test");
	}
	@AfterAll
	public static void tearDownAll() {
		System.out.println("Should execute before all test");
	}
	@Test
	@DisplayName("Should Create Contact")
	void shouldCreateContact() {
		ContactManager contact = new ContactManager();
		contact.addContact("Nhat", "Le", "0123456789");
		assertFalse(contact.getAllContacts().isEmpty());
		assertEquals(1,contact.getAllContacts().size());
	}
	@Test
	@DisplayName("Should Not Create Contact When FirstName Is Null")
	void shouldThrowExceptionWhenFirstNameIsNull() {
		ContactManager contact = new ContactManager();
		assertThrows(RuntimeException.class, () -> {
			contact.addContact(null,"Le", "0123456789");
		});
		
	}
	@Test
	@DisplayName("Should Not Create Contact When LastName Is Null")
	void shouldThrowExceptionWhenLastNameIsNull() {
		ContactManager contact = new ContactManager();
		assertThrows(RuntimeException.class, () -> {
			contact.addContact("Nhat",null, "0123456789");
		});
		
	}
	@Test
	@DisplayName("Should Not Create Contact When Phone Is Null")
	void shouldThrowExceptionWhenPhoneNumberIsNull() {
		ContactManager contact = new ContactManager();
		assertThrows(RuntimeException.class, () -> {
			contact.addContact("Nhat","Le",null);
		});
		
	}
	
	
	@Test
	@DisplayName("Should Create Contact on Mac")
	@EnabledOnOs(value=OS.MAC,disabledReason= "for Mac Only")
	void shouldCreateContactOnMac() {
		ContactManager contact = new ContactManager();
		contact.addContact("Nhat", "Le", "0123456789");
		assertFalse(contact.getAllContacts().isEmpty());
		assertEquals(1,contact.getAllContacts().size());
	}
	
}
