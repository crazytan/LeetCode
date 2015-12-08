public class Solution {

    public int numTrees(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] cnt = new int[n+1];
        cnt[0] = 1;
        cnt[1] = 1;
        cnt[2] = 2;
        for (int i = 3;i <= n;i++)
            for (int j = 0;j <= (i-1);j++)
                cnt[i] += cnt[j] * cnt[i-1-j];
        return cnt[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(4));
    }
}
