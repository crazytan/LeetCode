import java.util.*;

public class Solution {

    public int maxProfit(int[] prices) {
        int k = Math.min(2, prices.length / 2);
        int[] f = new int[prices.length + 1];
        int[] _f = new int[prices.length + 1];
        int[] maxProfit = new int[prices.length + 1];
        for (int j = 1;j <= k;j++) {
            _f[1] = f[1];
            for (int i = 2;i <= prices.length;i++) _f[i] = Math.max(_f[i - 1],f[i]);
            maxProfit[1] = f[0] - prices[0];
            for (int i = 2;i <= prices.length;i++) maxProfit[i] = Math.max(maxProfit[i - 1], _f[i - 1] - prices[i - 1]);
            for (int i = 2;i <= prices.length;i++) f[i] = Math.max(f[i], maxProfit[i - 1] + prices[i - 1]);
        }
        int ans = 0;
        for (int i = 1;i <= prices.length;i++)
            if (f[i] > ans) ans = f[i];
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {7, 9, 2, 8, 4, 10, 3, 22, 5, 11, 19, 0, 15}));
    }
}