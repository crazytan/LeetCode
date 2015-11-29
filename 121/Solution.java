import java.util.*;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length <= 0) return 0;
        int ans = 0;
        int min = prices[0];
        for (int i = 1;i < prices.length;i++) {
            if ((prices[i] - min) > ans) ans = prices[i] - min;
            if (prices[i] < min) min = prices[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {7, 9, 2, 8, 4, 10, 3, 22, 5, 11, 19, 0, 15}));
    }
}