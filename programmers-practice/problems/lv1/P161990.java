import java.util.Arrays;

public class P161990 {

    public int[] solution(String[] wallpaper) {
        int minX = 51;
        int maxX = -1;
        int minY = 51;
        int maxY = -1;
        
        for(int i=0;i<wallpaper.length;i++){
            String row = wallpaper[i];
            for(int j=0;j<row.length();j++){
                boolean hasFile = row.charAt(j)=='#';
                if(hasFile){
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                }
            }
        }
        
        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }

    public static void main(String[] args) {
        P161990 wpSolver = new P161990();
        String[][] wallpapers = {
            {".#...", "..#..", "...#."},
            {"..........", ".....#....", "......##..", "...##.....", "....#....."},
            {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."},
            {"..", "#."}
        };
        int[][] expectedAreas = {
            {0, 1, 3, 4},
            {1, 3, 5, 8},
            {0, 0, 7, 9},
            {1, 0, 2, 1}
        };

        for (int i = 0; i < wallpapers.length; i++) {
            int[] area = wpSolver.solution(wallpapers[i]);
            System.out.println("Wallpaper Test Case " + (i + 1) + ": " + (Arrays.equals(area, expectedAreas[i]) ? "Passed" : "Failed") + " (Result: " + Arrays.toString(area) + ")");
        }
    }
}
