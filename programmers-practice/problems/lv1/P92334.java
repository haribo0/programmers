
import java.util.*;

public class P92334 {

    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Set<String>> map = new HashMap<>();
        HashMap<String, Integer> emailCount = new HashMap<>();

        for(String user:id_list) {
            map.put(user, new HashSet<>());
            emailCount.put(user, 0);
        }
        for(String rep:report) {
            String[] r = rep.split(" ");
            map.get(r[1]).add(r[0]);
        }
        int[] result = new int[id_list.length];
        for(String name:id_list) {
            if(map.get(name).size()>=k) {
                for(String reporter : map.get(name)) {
                    emailCount.put(reporter, emailCount.get(reporter)+1);
                }
            }
        }
        for(int i=0;i<id_list.length;i++) {
            result[i] = emailCount.get(id_list[i]);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
