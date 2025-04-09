public class P136798 {
     private static int countDivisors(int number) {
        int count = 0;
        int sqrt = (int) Math.sqrt(number);
        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                count++; // i
                if (i != number / i) {
                    count++; // number / i
                }
            }
        }
        return count;
    }

    public int solution(int number, int limit, int power) {
        int totalWeight = 0;
        for (int i = 1; i <= number; i++) {
            int divisors = countDivisors(i);
            totalWeight += (divisors > limit) ? power : divisors;
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        P136798 sol = new P136798();
        int[][] testCases = {
            {5, 3, 2, 10},
            {10, 3, 2, 21},
        };

        for (int[] test : testCases) {
            int number = test[0];
            int limit = test[1];
            int power = test[2];
            int expected = test[3];

            int result = sol.solution(number, limit, power);
            String status = (result == expected) ? "[PASS]" : "[FAIL]";

            System.out.printf("expected: %d, result: %d → %s%n",
                    expected, result, status);
        }
    }
}
