public class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] gymClothes = new int[n+1];

        for(int st : lost) {
            gymClothes[st]--;
        }
        for(int st : reserve) {
            gymClothes[st]++;
        }

        for(int i=1;i<=n;i++) {
            if(gymClothes[i]==-1){
                if(gymClothes[i-1]>0) {
                    gymClothes[i-1]--;
                    gymClothes[i]++;
                } else if (i!=n && gymClothes[i+1]>0) {
                    gymClothes[i+1]--;
                    gymClothes[i]++;
                } else {
                    answer--;
                }
            }

        }
        
        return answer;
    }
    public static void main(String[] args) {
        // n	lost	reserve	return
        // 5	[2, 4]	[1, 3, 5]	5
        // 5	[2, 4]	[3]	4
        // 3	[3]	[1]	2

        P42862 p = new P42862();
        int n = 5;
        int[] lost1 = {2,4};
        int[] reserve1 = {1,3,5};

        int[] lost2 = {2,4};
        int[] reserve2 = {3};

        int[] lost3 = {3};
        int[] reserve3 = {1};

        ;
        System.out.println(p.solution(5, lost1, reserve1));
        System.out.println(p.solution(5, lost2, reserve2));
        System.out.println(p.solution(3, lost3, reserve3));
        
        
    }
}
