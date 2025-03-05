package Lab3;

import java.util.ArrayList;
import java.util.Collections;

public class TwoNumbersSum {

    public ArrayList<Integer> addTwoNumbers(ArrayList<Integer> first, ArrayList<Integer> second) {
        Collections.reverse(first);
        Collections.reverse(second);
  

        int complement = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < Math.max(first.size(), second.size()); i++){
            int firstVal = i < first.size() ? first.get(i) : 0;
            int secondVal = i < second.size() ? second.get(i) : 0;
            int total = firstVal + secondVal + complement;
            complement = 0;
            if (total >= 10){ 
                complement = 1;
                total -= 10;
            }
            
            
           // result.add(i, total);
          //no need to insert index
            result.add( total);
        }
        //here the missing that lead to a bug
        if (complement != 0) {
            result.add(complement); // Add the last carry if there is one
        }

        Collections.reverse(result);
        return result;
    }
}

