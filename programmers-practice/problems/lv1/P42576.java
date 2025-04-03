import java.util.HashMap;

public class P42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) map.put(player, map.getOrDefault(player, 0) + 1);
        for (String player : completion) map.put(player, map.get(player) - 1);

        for (String key : map.keySet()) {
            if (map.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P42576 solver = new P42576();

        String[][] participants = {
            {"leo", "kiki", "eden"},
            {"marina", "josipa", "nikola", "vinko", "filipa"},
            {"mislav", "stanko", "mislav", "ana"}
        };
        String[][] completions = {
            {"eden", "kiki"},
            {"josipa", "filipa", "marina", "nikola"},
            {"stanko", "ana", "mislav"}
        };
        String[] expected = {
            "leo","vinko","mislav"
        };
        for(int i=0;i<participants.length;i++){
            String result = solver.solution(participants[i], completions[i]);
            System.out.println("expected= "+expected[i]+", result= "+result+", Test= "+ (expected[i].equals(result)?"[PASS]":"[FAIL]"));
        }
    }
}
