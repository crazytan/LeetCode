public class Solution {
    private static final int[][] arr = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) ans.add(matrix[0][i]);
            return ans;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) ans.add(matrix[i][0]);
            return ans;
        }
        int h = matrix.length, w = matrix[0].length;
        int x = 0, y = 0, dir = 0;
        boolean[][] map = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) map[i][j] = true;
        }
        while (map[x][y]) {
            ans.add(matrix[x][y]);
            map[x][y] = false;
            if ((x + arr[dir][0] < 0) || (y + arr[dir][1] < 0) || (x + arr[dir][0] >= h) || (y + arr[dir][1] >= w) || !map[x + arr[dir][0]][y + arr[dir][1]]) {
                dir = (dir + 1) % 4;
            }
            x += arr[dir][0];
            y += arr[dir][1];
        }
        return ans;
    }
}
