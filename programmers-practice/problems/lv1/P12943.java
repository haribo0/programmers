public class P12943 {
    public int solution(int num) {
        int count = 0;	
        long n = (long)num;
        if (num==1 && count==0) return 0;
		for (int i=0;i<500;i++) {
			if (n==1) break;
			if (n%2==0) n/=2;
			else {
				n = (n*3)+1;
			}
			count++;
		}
        return (n == 1 ? count : -1);
    }
    public static void main(String[] args) {
        P12943 sol = new P12943();

        int[] testCases = {6, 16, 626331};
        int[] expectedResults = {8,4,-1};
        for (int i=0;i<testCases.length;i++) {
            int result = sol.solution(testCases[i]);
            int expected = expectedResults[i];
            System.out.println("expected: " + expected + ", result: " + result+" "+(result==expected?"[PASS]":"[FAIL]"));
        }
    }
}
