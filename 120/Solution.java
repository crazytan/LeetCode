import java.util.*;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() <= 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int d = triangle.size();
        int[][] min = new int[d][];
        for (int i = 0;i < d;i++) min[i] = new int[d];
        min[0][0] = triangle.get(0).get(0);
        for (int i = 1;i < d;i++)
            for (int j = 0;j <= i;j++) {
                // min[i-1][j], min[i-1][j-1]
                int num = triangle.get(i).get(j);
                min[i][j] = Integer.MAX_VALUE;
                if ((i-1) >= j) min[i][j] = min[i-1][j] + num;
                if (j-1 >= 0) min[i][j] = Math.min(min[i][j], min[i-1][j-1] + num);
            }
        int ans = Integer.MAX_VALUE;
        for (int i = 0;i < d;i++)
            if (min[d-1][i] < ans) ans = min[d-1][i];
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(Arrays.asList(new Integer[] {2}));
        tri.add(Arrays.asList(new Integer[] {3,4}));
        tri.add(Arrays.asList(new Integer[] {6,5,7}));
        tri.add(Arrays.asList(new Integer[] {4,1,8,3}));
        System.out.println(new Solution().minimumTotal(tri));
    }
}
