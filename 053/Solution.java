public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) return 0;
        if (nums.length == 1) return nums[0];
        int sum = nums[0] > 0 ? nums[0] : 0;
        int ans = nums[0];
        for (int i = 1;i < nums.length;i++) {
            if (sum + nums[i] <= 0) {
                if (nums[i] > ans) ans = nums[i];
                sum = 0;
            } else {
                sum += nums[i];
                if (sum > ans) ans = sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[] {-2,-1}));
    }
}
