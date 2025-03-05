package Testing;

import java.util.*;
import java.util.stream.IntStream;
import java.io.*;
import java.lang.reflect.Array;

public class Test {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int x = sc.nextInt();
		int[] prices = new int[3];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = sc.nextInt();
		}
		
		long[] dp = new long[x+1];
		Arrays.fill(dp, -1);
		dp[0] =0;
 		for (int price : prices) {
			for (int i = price; i <=x; i++) {
				if(dp[i-price] != -1) {
					dp[i] = Math.max(dp[i], dp[i-price] + 1);
				}
			}
		}
 		System.out.println(dp[x]);
	}
}
