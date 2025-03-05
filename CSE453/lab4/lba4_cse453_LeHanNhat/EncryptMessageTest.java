package Lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EncryptMessageTest {

	 @Test
	    public void testEncryptionWithEvenLengthMessage() {
	        // Test case with even length message
	        String input = "abcd";
	        String expectedOutput = "yzwx";
	        String result = new EncryptMessage().Encryption(input);
	        assertEquals(expectedOutput, result);
	    }
	    
	    @Test
	    public void testEncryptionWithOddLengthMessage() {
	        // Test case with odd length message
	        String input = "world";
	        String expectedOutput = "ldoiw";
	        String result = new EncryptMessage().Encryption(input);
	        assertEquals(expectedOutput, result);
	    }
	    
	    @Test
	    public void testEncryptionWithSingleCharacter() {
	        // Test case with single character
	        String input = "a";
	        String result = new EncryptMessage().Encryption(input);
	        assertEquals("z", result);
	    }
	    
	    @Test
	    public void testEncryptionWithInvalidCharacters() {
	        // Test cases with non-lowercase characters
	        String[] invalidInputs = {"Hello", "world!", "WORLD", "w0rld"};
	        
	        for (String input : invalidInputs) {
	            String result = new EncryptMessage().Encryption(input);
	            assertEquals("invalid", result);
	        }
	    }
	    
	    @Test
	    public void testEncryptionWithSpecialCharacters() {
	        // Test case with special characters
	        String input = "ab!c";
	        String result = new EncryptMessage().Encryption(input);
	        assertEquals("invalid", result);
	    }
	    
	    @Test
	    public void testEncryptionWithEmptyString() {
	        // Test case with empty string
	        String input = "";
	        String result = new EncryptMessage().Encryption(input);
	        assertEquals("", result);
	    }
	    @Test
	    public void testspecialEncryptionCharacterShift() {
	        // Test the character shift logic
	        String input = "A";
	        String expectedOutput = "invalid";
	        String result = new EncryptMessage().Encryption(input);
	        assertEquals(expectedOutput, result);
	    }
	    @Test
	    public void testspecial2EncryptionCharacterShift() {
	        // Test the character shift logic
	        String input = "é";
	        String expectedOutput = "invalid";
	        String result = new EncryptMessage().Encryption(input);
	        assertEquals(expectedOutput, result);
	    }
	    @Test
	    public void testEncryptionCharacterShift() {
	        // Test the character shift logic
	        String input = "az";
	        String expectedOutput = "az";
	        String result = new EncryptMessage().Encryption(input);
	        assertEquals(expectedOutput, result);
	    }
	    @Test
	    public void testreverseEncryptionCharacterShift() {
	        // Test the character shift logic
	        String input = "za";
	        String expectedOutput = "za";
	        String result = new EncryptMessage().Encryption(input);
	        assertEquals(expectedOutput, result);
	    }
}
