package Lab3;

import java.util.*;

public class ColorFlipPuzzle {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] flips = {{0,1,3}, {0,1,2,4}, {1,2,5}, {0,3,4,6}, {1,3,4,5,7}, {2,4,5,8}, {3,6,7}, {4,6,7,8}, {5,7,8}};
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            int target = 0;
            for(int i = 0; i < 3; i++) {
                String s = sc.nextLine();
                for(int j = 0; j < 3; j++) {
                    if(s.charAt(j) == '*') {
                        target |= (1 << (i*3+j));
                    }
                }
            }
            
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> seen = new HashSet<>();
            q.offer(0);
            seen.add(0);
            int steps = 0;
            
            while(!q.isEmpty()) {
                for(int size = q.size(); size > 0; size--) {
                    int cur = q.poll();
                    if(cur == target) {
                        System.out.println(steps);
                        q.clear();
                        break;
                    }
                    for(int i = 0; i < 9; i++) {
                        int next = cur;
                        for(int pos : flips[i])
                            next ^= 1 << pos;
                        if(seen.add(next))
                            q.offer(next);
                    }
                }
                steps++;
            }
        }
        sc.close();
    }
}