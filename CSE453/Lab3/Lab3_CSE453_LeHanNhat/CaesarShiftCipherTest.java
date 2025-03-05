package Lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CaesarShiftCipherTest {

	CaesarShiftCipher cipher = new CaesarShiftCipher();

   
    @Test
    void testStandardShift() {
        String message = "ATTACKATONCE";
        int shift = 4;
        String result = cipher.CaesarShift(message, shift);
        assertEquals("EXXEGOEXSRGI", result);
    }

  
    @Test
    void testWraparoundShift() {
        String message = "XYZ";
        int shift = 3;
        String result = cipher.CaesarShift(message, shift);
        assertEquals("ABC", result);
    }

   
    @Test
    void testZeroShift() {
        String message = "HELLO";
        int shift = 0;
        String result = cipher.CaesarShift(message, shift);
        assertEquals("HELLO", result);
    }

    
    @Test
    void testFullAlphabetShift() {
        String message = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int shift = 26;
        String result = cipher.CaesarShift(message, shift);
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", result);
    }

   
    @Test
    void testShiftGreaterThan26() {
        String message = "HELLO";
        int shift = 29;
        String result = cipher.CaesarShift(message, shift);
        assertEquals("KHOOR", result);
    }

   
    @Test
    void testSingleCharacterShift() {
        String message = "A";
        int shift = 1;
        String result = cipher.CaesarShift(message, shift);
        assertEquals("B", result);
    }

  
    @Test
    void testInvalidInput() {
        String message = "Hello";
        int shift = 4;
        String result = cipher.CaesarShift(message, shift);
        assertEquals("invalid", result);
    }

   
    @Test
    void testNegativeShift() {
        String message = "ATTACK";
        int shift = -1;
        String result = cipher.CaesarShift(message, shift);
        assertEquals("ZSSZBJ", result);
    }

  
   

    
    @Test
    void testInvalidCharacterInMessage() {
        String message = "12345";
        int shift = 5;
        String result = cipher.CaesarShift(message, shift);
        assertEquals("invalid", result);
    }

}
