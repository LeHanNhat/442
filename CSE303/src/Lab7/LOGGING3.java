package Lab7;

import java.util.*;

import java.io.*;

public class LOGGING3 {
	static Scanner sc = new Scanner(System.in);
	static final long MOD = (long)Math.pow(10, 9) + 7;;
	public static void main(String[] args) {
		int n = sc.nextInt();
		long[] list = new long[n];
        long[] ways = new long[n];
        long[] values = new long[n];
        for (int i = 0; i < n; i++) {
        	values[i] = sc.nextLong();
		}
        long MOD = 1000000007;
       
        
        
        list[0] = Math.max(0, values[0]);
        ways[0] = 1;
        
        if (n > 1) {
		    list[1] = Math.max(list[0], values[1]);
		    ways[1] = 0;
		    if (list[1] == values[1]) ways[1] = 1;
		    if (list[1] == list[0]) ways[1] = (ways[1] + ways[0]) % MOD;
		}

        for (int i = 2; i < n; i++) {
		    long cn = values[i];

		    list[i] = list[i-1];
		    ways[i] = ways[i-1];

		    long count = list[i-2] + cn;
		    if (count > list[i]) {
		    	list[i] = count;
		        ways[i] = ways[i-2];
		    } else if (count == list[i]) {
		        ways[i] = (ways[i] + ways[i-2]) % MOD;
		    }
		}
        
        
        System.out.println(list[n-1] + " " + ways[n-1]);
    }
}