import java.util.*;

public class P138476 {
    
    public int solution(int k, int[] tangerine) {
        int types = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int size : tangerine){
            countMap.put(size, countMap.getOrDefault(size,0)+1);
        }
        List<Integer> frequencies = new ArrayList<>(countMap.values());
        frequencies.sort(Collections.reverseOrder());
        for(Integer n : frequencies){
            k -= n;
            types++;
            if(k<=0) break;
        }

        return types;
    }

    public static void main(String[] args) {
        P138476 solver = new P138476();
        
        int[][] testCases = {
            {6, 1, 3, 2, 5, 4, 5, 2, 3},
            {4, 1, 3, 2, 5, 4, 5, 2, 3},
            {2, 1, 1, 1, 1, 2, 2, 2, 3}
        };
        int[] expectedResults = {3, 2, 1};
        
        for (int i = 0; i < testCases.length; i++) {
            int k = testCases[i][0];
            int[] tangerine = Arrays.copyOfRange(testCases[i], 1, testCases[i].length);
            int result = solver.solution(k, tangerine);
            System.out.println("Test Case " + (i + 1) + ": " + (result == expectedResults[i] ? "Passed" : "Failed") + " (Result: " + result + ")");
        }
    }

}
