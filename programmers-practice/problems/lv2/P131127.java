import java.util.HashMap;
import java.util.Map;

public class P131127 {

    private boolean isMatch(Map<String, Integer> wantMap, Map<String, Integer> windowMap) {
        for (String key : wantMap.keySet()) {
            if (windowMap.getOrDefault(key, 0) < wantMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int total = 0;

        Map<String,Integer> wantMap = new HashMap<>();
        for(int i=0;i<want.length;i++){
            wantMap.put(want[i],number[i]);
            total+=number[i];
        }
        
        Map<String,Integer> discountMap = new HashMap<>();
        for(int i=0;i<10;i++){
            discountMap.put(discount[i],discountMap.getOrDefault(discount[i],0)+1);
        }
        if (isMatch(wantMap, discountMap)) answer++;

        for(int i=10;i<discount.length;i++){
            String removeItem = discount[i-10];
            discountMap.put(removeItem,discountMap.getOrDefault(removeItem,0)-1);
            String newItem = discount[i];
            discountMap.put(newItem,discountMap.getOrDefault(newItem,0)+1);
            if(isMatch(wantMap, discountMap)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        P131127 p = new P131127();

        String[][] wants = {
            {"banana", "apple", "rice", "pork", "pot"},
            {"apple"}
        };
        int[][] numbers = {
            {3, 2, 2, 2, 1},
            {10}
        };
        String[][] discounts = {
            {"chicken", "apple", "apple", "banana", "rice", "apple", "pork",
             "banana", "pork", "rice", "pot", "banana", "apple", "banana"},
            {"banana", "banana", "banana", "banana", "banana",
             "banana", "banana", "banana", "banana", "banana"}
        };

        int[] expectedResults = {3, 0};

        for (int i = 0; i < wants.length; i++) {
            int result = p.solution(wants[i], numbers[i], discounts[i]);
            String status = result == expectedResults[i] ? "PASS" : "FAIL";
            System.out.printf("Test case %d result: %d (expected: %d) => %s%n",
                              i + 1, result, expectedResults[i], status);
        }


    }
}
