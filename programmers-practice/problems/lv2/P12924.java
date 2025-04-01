public class P12924 {
    public int solution(int n) {
        int count = 0;
        for (int k = 1; k * (k - 1) / 2 < n; k++) {
            if ((n - (k * (k - 1)) / 2) % k == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        P12924 solver = new P12924();

        int n = 15;
        int expected = 4;

        int result = solver.solution(n);
        System.out.println( "expected= "+expected+", result= "+result+ ": "+ (expected==result?"PASS":"FAIL"));
        
    }
}
