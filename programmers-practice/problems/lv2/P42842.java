import java.util.*;

public class P42842 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int h=1;h<=Math.sqrt(yellow);h++){
            int w = yellow/h;
            if(yellow%h==0){
                if(2*(h+w)+4 == brown){
                answer[0] = w+2;
                answer[1] = h+2;
            }
            }
        }
        
        return answer;
    }
    public static void main(String[] args) {
        P42842 solver = new P42842();
        
        int[][] testCases = {
            {10, 2},
            {8, 1},
            {24, 24}
        };
        int[][] expectedResults = {
            {4, 3},
            {3, 3},
            {8, 6}
        };
        
        for (int i = 0; i < testCases.length; i++) {
            int brown = testCases[i][0];
            int yellow = testCases[i][1];
            int[] result = solver.solution(brown, yellow);
            System.out.println("Test Case " + (i + 1) + ": " + (Arrays.equals(result, expectedResults[i]) ? "Passed" : "Failed") + " (Result: " + Arrays.toString(result) + ")");
        }
    }
}
