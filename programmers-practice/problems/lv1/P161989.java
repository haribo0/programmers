public class P161989 {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int index = 0;
        while (index < section.length) {
            int paintedUntil = section[index] + m - 1;
            while (index < section.length && section[index] <= paintedUntil) {
                index++;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        P161989 solver = new P161989();
        Object[][] testCases = {
            {8, 4, 2, new int[]{2, 3, 6}},
            {5, 4, 1, new int[]{1, 3}},
            {4, 1, 4, new int[]{1, 2, 3, 4}}
        };

        for (int i = 0; i < testCases.length; i++) {
            int n = (int) testCases[i][0];
            int m = (int) testCases[i][1];
            int expected = (int) testCases[i][2];
            int[] section = (int[]) testCases[i][3];

            int result = solver.solution(n, m, section);
            System.out.printf("Test Case %d - expected: %d, result: %d, %s%n",
                i + 1, expected, result, result == expected ? "PASS" : "FAIL");
        }
    }
}
