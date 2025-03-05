public class P389478 {
    class Solution {
        public int solution(int n, int w, int num) {
            int row = (num - 1) / w;
            int col = (num - 1) % w;
    
            if (row % 2 == 1) {
                col = w - 1 - col;
            }
    
            int count = 1;
            int totalRows = (n - 1) / w + 1;
    
            for (int r = row + 1; r < totalRows; r++) {
                int maxColAtRow = (r == totalRows - 1) ? (n - 1) % w : w - 1;
                if (r % 2 == 1) {
                    if (w - 1 - col <= maxColAtRow) {
                        count++;
                    }
                } else {
                    if (col <= maxColAtRow) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
