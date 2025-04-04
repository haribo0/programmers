import java.util.Arrays;

public class P340213 {
    
    private static int convertTimeToSec(String time){
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    private static String convertSecToTime(int sec){
        int minutes = sec / 60;
        int seconds = sec % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    
    private static int skipOpeningIfInRange(int pos, int opStart, int opEnd) {
        return (pos >= opStart && pos < opEnd) ? opEnd : pos;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = convertTimeToSec(video_len);
        int position = convertTimeToSec(pos);
        int op_s = convertTimeToSec(op_start);
        int op_e = convertTimeToSec(op_end);
        
        position = skipOpeningIfInRange(position, op_s, op_e);
        
        for (String command : commands) {
            if (command.equals("prev")) {
                position = Math.max(0, position - 10);
            } else if (command.equals("next")) {
                position = Math.min(len, position + 10);
            }
            position = skipOpeningIfInRange(position, op_s, op_e);
        }
        
        return convertSecToTime(position);
    }

    public static void main(String[] args) {

        P340213 obj = new P340213();

        String[][] testCases = {
            {"34:33", "13:00", "00:55", "02:55", "next,prev", "13:00"},
            {"10:55", "00:05", "00:15", "06:55", "prev,next,next", "06:55"},
            {"07:22", "04:05", "00:15", "04:07", "next", "04:17"}
        };

        for (String[] testCase : testCases) {
            String video_len = testCase[0];
            String pos = testCase[1];
            String op_start = testCase[2];
            String op_end = testCase[3];
            String[] commands = testCase[4].split(",");
            String expected = testCase[5];

            String result = obj.solution(video_len, pos, op_start, op_end, commands);
            System.out.println("Expected: " + expected + ", Actual: " + result);
            System.out.println(result.equals(expected) ? "✅ PASS" : "❌ FAIL");
            System.out.println();
        }
        
    }
}
