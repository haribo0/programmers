public class P140108 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            
            int sameCnt = 0;
            int otherCnt = 0;
            String letter = "";
            for(String str : s.split("")){
                if(letter.equals("")){
                    letter = str;
                    sameCnt++;
                    continue;
                }
                if(letter.equals(str)){
                    sameCnt++;
                    System.out.println("sameCnt="+sameCnt);
                }else{
                    otherCnt++;
                    System.out.println("otherCnt="+otherCnt);
                }
                if(sameCnt==otherCnt){
                    answer++;
                    sameCnt=0;
                    otherCnt=0;
                    letter="";
                }
            }
            if(letter.equals("")) return answer;
            
            return ++answer;
            
        }
    }
    public static void main(String[] args) {
        Solution s = new P140108().new Solution();
        String str1 = "banana";
        String str2 = "abracadabra";
        String str3 = "aaabbaccccabba";
        s.solution(str1);
        s.solution(str2);
        s.solution(str3);
    }
}
