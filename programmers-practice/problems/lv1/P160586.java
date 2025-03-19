import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P160586 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> keyPressCount = new HashMap<>();

        for(String key : keymap){
            for (int pressCount = 0; pressCount < key.length(); pressCount++) {
                char ch = key.charAt(pressCount);
                keyPressCount.put(ch, Math.min(keyPressCount.getOrDefault(ch, Integer.MAX_VALUE), pressCount + 1));
            }
        }

        for(int i=0;i<targets.length;i++){
            int countSum = 0;
            String target = targets[i];
            for(int j=0;j<target.length();j++){
                Integer minCount = keyPressCount.get(target.charAt(j));
                if (minCount == null) {
                    countSum = -1;
                    break;
                }
                countSum += minCount;
            }
            answer[i] = countSum;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        P160586 solver = new P160586();
        
        String[][] testKeymaps = {
            {"ABACD", "BCEFD"},
            {"AA"},
            {"AGZ", "BSSS"}
        };
        
        String[][] testTargets = {
            {"ABCD", "AABB"},
            {"B"},
            {"ASA", "BGZ"}
        };
        
        int[][] expectedResults = {
            {9, 4},
            {-1},
            {4, 6}
        };
        
        for (int i = 0; i < testKeymaps.length; i++) {
            int[] result = solver.solution(testKeymaps[i], testTargets[i]);
            System.out.println("Test Case " + (i + 1) + ": " + (Arrays.equals(result, expectedResults[i]) ? "Passed" : "Failed") + " (Result: " + Arrays.toString(result) + ")");
        }
    }
}
