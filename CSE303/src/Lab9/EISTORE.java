package Lab9;

import java.util.Arrays;
import java.util.Scanner;

public class EISTORE {
	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = reader.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < prices.length; i++) {
			prices[i]=reader.nextInt();
		}
 		Arrays.sort(prices);
		
		int[] dp = new int[m+1];		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		for(int price : prices) {
			for (int i = price; i <= m; i++) {
				if(dp[i-price] !=  Integer.MAX_VALUE ) {
					dp[i] = Math.min(dp[i-price]+1,dp[i] )  ;
				}
				
			}
		}
		System.out.println(dp[m]);
	}
}
