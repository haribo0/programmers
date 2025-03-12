import java.util.*;

public class P64061 {

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int move:moves) {
            for(int[] row : board) {
                if(row[move-1]>0) {
                    if(!stack.isEmpty() && stack.peek()==row[move-1]) {
                        stack.pop();
                        answer+=2;
                    } else {
                        stack.push(row[move-1]);
                    }
                    row[move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        P64061 game = new P64061();
        
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int expected = 4;
        
        int result = game.solution(board, moves);
        System.out.println("Result: " + result);
        System.out.println("Test " + (result == expected ? "Passed" : "Failed"));
    }
}

