import java.util.Stack;

public class P12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
    
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
    
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        P12909 solver = new P12909();

        String[] testCases = {"()()", "(())()", ")()(", "(()("};
        boolean[] expected = {true, true, false, false};

        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i];
            boolean result = solver.solution(input);
            System.out.println("Input: " + input + " | Expected: " + expected[i] + " | Result: " + result + " | " + (result == expected[i] ? " Pass" : " Fail"));
        }
    }
}
