public class P388351 {
    class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startDay) {
            int eligibleEmployeesCount = 0;
    
            for (int i = 0; i < schedules.length; i++) {
                int desiredArrivalTime = schedules[i];
                boolean isEligible = true;
    
                for (int j = 0; j < 7; j++) {
                    int dayIdx = (startDay + j - 1) % 7;
                    boolean isWeekend = dayIdx == 5 || dayIdx == 6;
                    
                    if (isWeekend) {
                        continue;
                    }
                    
                    int actualArrivalTime = timelogs[i][j];
                    if (!isOnTime(desiredArrivalTime, actualArrivalTime)) {
                        isEligible = false;
                        break;
                    }
                }
    
                if (isEligible) {
                    eligibleEmployeesCount++;
                }
            }
            return eligibleEmployeesCount;
        }
        
        private boolean isOnTime(int desiredArrivalTime, int actualArrivalTime) {
            int desiredArrivalHour = desiredArrivalTime / 100;
            int desiredArrivalMinute = desiredArrivalTime % 100;
            int actualArrivalHour = actualArrivalTime / 100;
            int actualArrivalMinute = actualArrivalTime % 100;
            
            int desiredArrivalTimePlus10 = desiredArrivalMinute + 10;
            if (desiredArrivalTimePlus10 >= 60) {
                desiredArrivalHour += 1;
                desiredArrivalTimePlus10 -= 60;
            }
    
            if (actualArrivalHour < desiredArrivalHour || (actualArrivalHour == desiredArrivalHour && actualArrivalMinute <= desiredArrivalTimePlus10)) {
                return true;
            } else {
                return false;
            }
        }
    }
    
}
