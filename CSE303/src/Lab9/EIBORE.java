package Lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class EIBORE {
	static Scanner rd = new Scanner(System.in);
	public static void main(String[] args) {
		int n = rd.nextInt();
		
		TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int point = rd.nextInt();
			map.put(point, map.getOrDefault(point, 0)+1);
		}
		
		ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
		
		int[] dp = new int[map.size()+1];
		dp[0] = 0;
		dp[1] = map.firstKey() * map.get(map.firstKey());
		
		for (int i = 2; i <= map.size(); i++) {
			int currentKey = keys.get(i - 1);
			if (currentKey == keys.get(i-2)+1) {
				int dk1 = dp[i - 2] + currentKey * map.get(currentKey);	         
	            int dk2 = dp[i - 1];            
	            dp[i] = Math.max(dk1, dk2);
			} else {
				dp[i] = dp[i - 1] + currentKey * map.get(currentKey);
			}
    
        }
		System.out.println(dp[map.size()]);
 	}
}
