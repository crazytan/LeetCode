import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static final int[][] arr = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[][] {};
        if (n == 1) return new int[][] {{1}};
        int[][] ans = new int[n][n];
        int x = 0, y = 0, dir = 0, cnt = 1;
        while (ans[x][y] == 0) {
            ans[x][y] = cnt++;
            if ((x + arr[dir][0] < 0) || (y + arr[dir][1] < 0) || (x + arr[dir][0] >= n) || (y + arr[dir][1] >= n) || (ans[x + arr[dir][0]][y + arr[dir][1]] != 0)) {
                dir = (dir + 1) % 4;
            }
            x += arr[dir][0];
            y += arr[dir][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] ans = s.generateMatrix(0);
        System.out.println(ans);
    }
}