public class Solution {
    private void dfs(int curr, int n, int c, int ld, int rd, int[] board, int[] ans) {
        if (curr >= n) {
            ans[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (((c & (1 << i)) == 0) && ((ld & (1 << i)) == 0) && ((rd & (1 << i)) == 0)) {
                board[curr] = i;
                dfs(curr + 1, n, c | (1 << i), (ld | (1 << i)) >> 1, (rd | (1 << i)) << 1, board, ans);
            }
        }
    }

    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] board = new int[n];
        int[] ans = new int[1];
        for (int i = 0; i < n; i++) {
            board[0] = i;
            dfs(1, n, 1 << i, (1 << i) >> 1, (1 << i) << 1, board, ans);
        }
        return ans[0];
    }
}
