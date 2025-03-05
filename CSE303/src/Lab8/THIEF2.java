package Lab8;

import java.util.Scanner;

public class THIEF2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	
		int n = sc.nextInt();
		int p = sc.nextInt();
		long[] maxV = new long[p+1];
		for (int i = 1; i <=n ; i++) {
			int w = sc.nextInt();
			long v = sc.nextLong();
			for (int j = p; j >= w ; j--) {
				maxV[j] = Math.max(maxV[j],maxV[j-w] +v);
			}
		}
		System.out.println(maxV[p]);
	}		
	
}
