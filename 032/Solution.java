public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        int ans = 0;
        int sum = 0;
        int[] l = new int[s.length()+1];
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == '(') sum++;
            else {
                if (sum == 0) {
                    if (l[0] > ans) ans = l[0];
                    l[0] = 0;
                }
                else {
                    if (l[sum] > ans) ans = l[sum];
                    l[sum-1] += l[sum] + 2;
                    l[sum] = 0;
                    sum--;
                }
            }
            if (l[sum] > ans) ans = l[sum];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(")(((((()())()()))()(()))("));
    }
}
