import java.util.ArrayList;

public class Solution {

    private Integer[] toArray(String num) {
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        while ((index < num.length()) && (num.charAt(index) == '0')) index++;
        if (index < num.length()) {
            for (int i = num.length() - 1; i >= index; i--) {
                list.add(Character.getNumericValue(num.charAt(i)));
            }
        }
        return list.toArray(new Integer[] {});
    }

    private void multiplyOneDigit(int[] ans, int digit, Integer[] num, int offset) {
        int carry = 0;
        for (int i = 0;i < num.length;i++) {
            carry += digit * num[i];
            ans[i + offset] += carry % 10;
            carry /= 10;
        }
        if (carry > 0) ans[num.length + offset] += carry;
    }

    public String multiply(String num1, String num2) {
        Integer[] num1_list, num2_list;
        num1_list = toArray(num1);
        num2_list = toArray(num2);
        if (num1_list.length == 0 || num2_list.length == 0) return "0";
        int[] ans = new int[num1_list.length + num2_list.length];
        for (int i = 0;i < num1_list.length;i++) {
            multiplyOneDigit(ans, num1_list[i], num2_list, i);
        }
        for (int i = 0;i < ans.length;i++) {
            if (ans[i] > 9) {
                ans[i + 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = ans.length - 1;
        while (ans[i] == 0) i--;
        for (;i >= 0;i--) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply("0", "000000022"));
    }
}
