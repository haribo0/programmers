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
}
