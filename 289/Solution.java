public class Solution {

    private int[][] dir = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};

    private boolean inside(int x, int y, int m, int n) {
        return !((x < 0) || (y < 0) || (x >= m) || (y >= n));
    }

    private int next(int now, int[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        int cnt = 0;
        for (int i = 0;i < 4;i++) {
            if (inside(x + dir[i][0], y + dir[i][1], m, n)) {
                if (board[x + dir[i][0]][y + dir[i][1]] >= 2) cnt++;
            }
        }
        for (int i = 4;i < 8;i++) {
            if (inside(x + dir[i][0], y + dir[i][1], m, n)) {
                if (board[x + dir[i][0]][y + dir[i][1]] == 1) cnt++;
            }
        }
        if (now == 0) return (cnt == 3) ? 1 : 0;
        return ((cnt >= 2) && (cnt <= 3)) ? 3 : 2;
    }

    public void gameOfLife(int[][] board) {
        if ((board == null) || (board.length == 0)) return;
        int m = board.length;
        int n = board[0].length;
/*        int[][] _board = new int[m][];
        for (int i = 0;i < m;i++) {
            _board[i] = new int[n];
            for (int j = 0;j < n;j++)
                _board[i][j] = board[i][j];
        }*/
        for (int i = 0;i < m;i++)
            for (int j = 0;j < n;j++)
                //board[i][j] = next(board[i][j], _board, i, j);
                board[i][j] = next(board[i][j], board, i, j);
        for (int i = 0;i < m;i++)
            for (int j = 0;j < n;j++)
                board[i][j] = board[i][j] & 1;
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,1,1,1,0},{0,1,1,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
        new Solution().gameOfLife(board);
        for (int i = 0;i < board.length;i++) {
            for (int j = 0; j < board[0].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
        new Solution().gameOfLife(board);
        for (int i = 0;i < board.length;i++) {
            for (int j = 0; j < board[0].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}