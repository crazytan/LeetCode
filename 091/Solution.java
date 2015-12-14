import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    private int decode(String s, int pos, int[] cnt) {
        if (pos >= s.length()) return 1;
        if (cnt[pos] >= 0) return cnt[pos];
        int tmp;
        cnt[pos] = 0;
        tmp = Integer.parseInt(s.substring(pos, pos + 1));
        if ((tmp >= 1) && (tmp <= 9))
            cnt[pos] += decode(s, pos + 1, cnt);
        if ((pos + 1) < s.length()) {
            tmp = Integer.parseInt(s.substring(pos, pos + 2));
            if ((tmp >= 10) && (tmp <= 26))
                cnt[pos] += decode(s, pos + 2, cnt);
        }
        return cnt[pos];
    }

    public int numDecodings(String s) {
        if (s == null) return 0;
        if (s.length() <= 0) return 0;
        int[] cnt = new int[s.length()];
        for (int i = 0;i < s.length();i++) cnt[i] = -1;
        return decode(s, 0, cnt);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
    }
}
