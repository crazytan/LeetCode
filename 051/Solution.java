public class Solution {
    private void addBoard(int[] board, List<List<String>> ans) {
        List<String> sol = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i]; j++) sb.append('.');
            sb.append('Q');
            for (int j = board[i] + 1; j < board.length; j++) sb.append('.');
            sol.add(sb.toString());
        }
        ans.add(sol);
    }

    private void dfs(int curr, int n, int c, int ld, int rd, int[] board, List<List<String>> ans) {
        if (curr >= n) {
            addBoard(board, ans);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (((c & (1 << i)) == 0) && ((ld & (1 << i)) == 0) && ((rd & (1 << i)) == 0)) {
                board[curr] = i;
                dfs(curr + 1, n, c | (1 << i), (ld | (1 << i)) >> 1, (rd | (1 << i)) << 1, board, ans);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<List<String>>();
        }
        List<List<String>> ans = new ArrayList<>();
        if (n == 1) {
            List<String> sol = new ArrayList<>();
            sol.add("Q");
            ans.add(sol);
            return ans;
        }
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            board[0] = i;
            dfs(1, n, 1 << i, (1 << i) >> 1, (1 << i) << 1, board, ans);
        }
        return ans;
    }
}
