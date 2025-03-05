package Lab3;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> first = new ArrayList<>(Arrays.asList(5, 6, 4));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(2, 4, 3 , 8, 9, 10));
        
        
        
        TwoNumbersSum adder = new TwoNumbersSum();
        ArrayList<Integer> result = adder.addTwoNumbers(first, second);
        for (int r : result) {
        	System.out.println(r);
		}
	}
}
