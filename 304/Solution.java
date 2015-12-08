public class Solution {

    public class NumMatrix {

        int h, w;

        int[][] sums;

        public NumMatrix(int[][] matrix) {
            sums = new int[matrix.length][];
            if (matrix.length > 0) {
                for (int i = 0;i < matrix.length;i++)
                    sums[i] = new int[matrix[0].length];
                this.h = matrix.length;
                this.w = matrix[0].length;

                sums[0][0] = matrix[0][0];
                for (int i = 1;i < h;i++) sums[i][0] = sums[i - 1][0] + matrix[i][0];
                for (int i = 1;i < w;i++) sums[0][i] = sums[0][i - 1] + matrix[0][i];
                for (int i = 1;i < h;i++)
                    for (int j = 1;j < w;j++)
                        sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if ((row1 == 0) && (col1 == 0)) return sums[row2][col2];
            if (row1 == 0) return sums[row2][col2] - sums[row2][col1 - 1];
            if (col1 == 0) return sums[row2][col2] - sums[row1 - 1][col2];
            return sums[row2][col2] + sums[row1-1][col1-1] - sums[row1-1][col2] - sums[row2][col1-1];
        }
    }

    public void test() {
        NumMatrix matrix = new NumMatrix(new int[][] {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});
        System.out.println(matrix.sumRegion(2,1,4,3));
        System.out.println(matrix.sumRegion(1,1,2,2));
        System.out.println(matrix.sumRegion(1,2,2,4));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.test();
    }
}
