package Lab9;

import java.util.Arrays;
import java.util.Scanner;

public class EIUCOL {
	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		int x = reader.nextInt();
		int[] prices = new int[3];
		for (int i = 0; i < prices.length; i++) {
			prices[i]=reader.nextInt();
		}
 		
		
		long[] dp = new long[x+1];
		
		
		Arrays.fill(dp, -1);
		dp[0]=0;
		for(int price : prices) {
			for (int i = price; i <= x; i++) {
				if(dp[i-price] != -1 ) {
					dp[i] = Math.max(dp[i-price]+1,dp[i] )  ;
				}
				
			}
		}
		System.out.println(dp[x]);
	}
}
