public class Solution {

    public int uniquePaths(int m, int n) {
        if ((m <= 0) || (n <= 0)) return 0;
        if ((m <= 1) || (n <= 1)) return 1;
        int[][] cnt = new int[m][];
        for (int i = 0;i < m;i++) cnt[i] = new int[n];
        for (int i = 0;i < m;i++) cnt[i][0] = 1;
        for (int i = 0;i < n;i++) cnt[0][i] = 1;
        for (int i = 1;i < m;i++)
            for (int j = 1;j < n;j++)
                cnt[i][j] = cnt[i - 1][j] + cnt[i][j - 1];
        return cnt[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3,7));
    }
}
