public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m <= 0) return 0;
        int n = obstacleGrid[0].length;
        if (n <= 0) return 0;
        if (obstacleGrid[0][0] > 0) return 0;
        if (obstacleGrid[m-1][n-1] > 0) return 0;
        int[][] cnt = new int[m][];
        for (int i = 0;i < m;i++) cnt[i] = new int[n];
        cnt[0][0] = 1;
        for (int i = 1;i < m;i++) {
            if (obstacleGrid[i][0] == 0) {
                cnt[i][0] = 1;
            }
            else {
                break;
            }
        }
        for (int i = 1;i < n;i++) {
            if (obstacleGrid[0][i] == 0) {
                cnt[0][i] = 1;
            }
            else {
                break;
            }
        }
        for (int i = 1;i < m;i++)
            for (int j = 1;j < n;j++) {
                if (obstacleGrid[i][j] == 0) {
                    cnt[i][j] = cnt[i-1][j] + cnt[i][j-1];
                }
                else {
                    cnt[i][j] = 0;
                }
            }
        return cnt[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsWithObstacles(new int[][] {{1}}));
    }
}
