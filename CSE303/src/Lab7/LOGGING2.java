package Lab7;

import java.util.*;

import java.io.*;

public class LOGGING2 {
	static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        for (int i =0 ; i < n ;i ++) {
        	long k = sc.nextInt();
        	long previous =0; 
        	if (i !=0) {
				previous = list.get(i-1);
			}
        	if(i<3) {
        		list.add(Math.max(k,previous));
        	} else {
        		list.add(Math.max(list.get(i-3)+k,previous));
        	}
       }
       
       System.out.println(list.get(n-1));
    }
}