import java.util.*;

public class P135808 {

    class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;
            
            Arrays.sort(score);
            for(int i=score.length-m;i>=0;i-=m){
                int price = score[i];
                answer += price*m;
            }
            
            return answer;
        }
    }

    public static void main(String[] args) {
        // k	m	score	result
        // 3	4	[1, 2, 3, 1, 2, 3, 1]	8
        // 4	3	[4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]	33

        Solution solution = new P135808().new Solution();
        int[] score1 = {1, 2, 3, 1, 2, 3, 1};
        int result = solution.solution(3, 4, score1);

    }
}
