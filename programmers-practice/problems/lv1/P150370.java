import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P150370 {
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }

        List<Integer> expiryList = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");
            LocalDate privacyDate = LocalDate.parse(privacyParts[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            int termMonths = termMap.get(privacyParts[1]);

            int newYear = privacyDate.getYear();
            int newMonth = privacyDate.getMonthValue() + termMonths;
            while (newMonth > 12) {
                newYear++;
                newMonth -= 12;
            }
            int newDay = privacyDate.getDayOfMonth();
            if (newDay == 0) { 
                newMonth--;
                if (newMonth == 0) { 
                    newMonth = 12;
                    newYear--;
                }
                newDay = 28;
            }
            LocalDate expiryDate = LocalDate.of(newYear, newMonth, newDay);
            

            if (!expiryDate.isAfter(todayDate)) {
                expiryList.add(i + 1);
            }
        }

        return expiryList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");

            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }

    
    public static void main(String[] args) {
        P150370 solver = new P150370();
        
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] expectedResult = {1, 3};
        
        int[] result = solver.solution(today, terms, privacies);
        System.out.println("Test Case: " + (Arrays.equals(result, expectedResult) ? "Passed" : "Failed") + " (Result: " + Arrays.toString(result) + ")");

        int[] result2 = solver.solution2(today, terms, privacies);
        System.out.println("Test Case: " + (Arrays.equals(result2, expectedResult) ? "Passed" : "Failed") + " (Result: " + Arrays.toString(result2) + ")");
    }
}
