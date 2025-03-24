import java.util.Arrays;

public class P12953 {

    
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }
        return lcm;
    }

    public static void main(String[] args) {

        P12953 solver = new P12953();   

        int[][] testCases = {
            {2,6,8,14},
            {1,2,3}
        };
        int[] expectedResults = {
            168,6
        };
        
        for (int i = 0; i < testCases.length; i++) {
            int result = solver.solution(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": " + ((expectedResults[i]==result) ? "Passed" : "Failed") + " (Result: " + result + ")");
        }
    }
    
}
