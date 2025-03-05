package Lab3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TwoNumbersSumTest {
	@Test
    public void testAddTwoNumbers() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(2, 4, 3));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(5, 6, 4));
        
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(8, 0, 7));
        
        TwoNumbersSum adder = new TwoNumbersSum();
        ArrayList<Integer> result = adder.addTwoNumbers(first, second);
        
        assertEquals(expected, result);
    }
	@Test
    public void testAddTwoNumbersList1Big() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(2, 4, 3 , 8, 9, 10));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(5, 6, 4));
        
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2,4,4,4,6,4));
        
        TwoNumbersSum adder = new TwoNumbersSum();
        ArrayList<Integer> result = adder.addTwoNumbers(first, second);
        
        assertEquals(expected, result);
    }
	@Test
    public void testAddTwoNumbersList2Big() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(5, 6, 4));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(2, 4, 3 , 8, 9, 10));
        
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2,4,4,4,6,4));
        
        TwoNumbersSum adder = new TwoNumbersSum();
        ArrayList<Integer> result = adder.addTwoNumbers(first, second);
        
        assertEquals(expected, result);
    }
	@Test
    public void testAddTwoNumberslost2() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(9,9));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1));
        
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,0,0));
        
        TwoNumbersSum adder = new TwoNumbersSum();
        ArrayList<Integer> result = adder.addTwoNumbers(first, second);
        
        assertEquals(expected, result);
    }
}
