public class Solution {
    public int jump(int[] nums) {
        if ((nums == null) || (nums.length <= 1)) return 0;
        int[] f = new int[nums.length];
        f[0] = 0;
        for (int i = 1;i < f.length;i++) f[i] = Integer.MAX_VALUE;
        for (int i = 0;i < (f.length - 1);i++) {
            if (!((i > 0) && (nums[i] < nums[i-1]))) {
                for (int j = i + 1; j < Math.min(i + nums[i] + 1, f.length); j++) {
                    if (f[i] + 1 < f[j]) f[j] = f[i] + 1;
                }
            }
        }
        return f[f.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[] {5,4,3,2,1}));
    }
}