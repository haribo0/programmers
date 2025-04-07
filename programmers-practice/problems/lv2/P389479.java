import java.util.PriorityQueue;

import java.util.*;

public class P389479 {
    public int solution(int[] players, int m, int k) {
        int result = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int server = 1;
        
        for(int time = 0; time < 24; time++) {
            int player = players[time];
            while(!pq.isEmpty() && pq.peek() <= time) {
                server--;
                pq.poll();
            }
            
            int remain = player - server * m;
            if(remain < 0) {
                continue;
            }
            
            while(remain >= 0) {
                result++;
                server++;
                pq.add(time + k);
                remain -= m;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        P389479 solver = new P389479();
        int[][] testPlayers = {
            {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},
            {0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}
        };

        int[] ms = {3, 5, 1};
        int[] ks = {5, 1, 1};
        int[] expected = {7, 11, 12};

        for (int i = 0; i < testPlayers.length; i++) {
            int result = solver.solution(testPlayers[i], ms[i], ks[i]);
            System.out.printf("Test %d: result = %d, expected = %d -> [%s]%n",
                i + 1, result, expected[i], result == expected[i] ? "PASS" : "FAIL");
        }

    }
}
