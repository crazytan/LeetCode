public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) return true;
        if (p.isEmpty()) return false;
        if (s.isEmpty() && p.equals("*")) return true;
        if (s.isEmpty()) return false;

        int len_s = s.length();
        int len_p = p.length();
        boolean[][] match = new boolean[len_s + 1][len_p + 1];
        for (int i = 0;i <= len_s;i++)
            for (int j = 0;j <= len_p;j++)
                match[i][j] = false;
        match[0][0] = true;
        int start = 1;
        while ((start <= len_p) && (p.charAt(start-1) == '*')) {
            for (int i = 0;i <= len_s;i++)
                match[i][start] = true;
            start += 1;
        }
        for (int i = 1;i <= len_s;i++)
            for (int j = start;j <= len_p;j++) {
                if (p.charAt(j-1) == '*') {
                    for (int k = 0;k <= i;k++) {
                        if (match[i-k][j-1]) {
                            match[i][j] = true;
                            break;
                        }
                    }
                }
                else {
                    match[i][j] = match[i-1][j-1];
                    if (p.charAt(j-1) != '?')
                        match[i][j] = match[i][j] && (p.charAt(j-1) == s.charAt(i-1));
                }
            }
        return match[len_s][len_p];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("ho", "*"));
    }
}
