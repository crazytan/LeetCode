public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return true;
        int l = nums.length;
        boolean[] reach = new boolean[l];
        for (int i = 0; i < l; i++) reach[i] = false;
        reach[0] = true;
        for (int i = 0; i < l; i++) {
            if (!reach[i]) return false;
            if (i + nums[i] >= (l - 1)) return true;
            for (int j = i + nums[i]; j > i; j--) {
                if (reach[j]) break;
                reach[j] = true;
            }
        }
        return false;
    }
}
