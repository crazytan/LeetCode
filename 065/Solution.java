public class Solution {
    private boolean isDigit(char c) {
        return ((c >= '0') && (c <= '9'));
    }

    private String reduceNumeric(String s) {
        if (s.isEmpty()) return s;
        int i = 0;
        while ((i < s.length()) && isDigit(s.charAt(i))) i++;
        if (i >= s.length()) return "";
        return s.substring(i);
    }

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) return false;
        while (s.charAt(0) == ' ') s = s.substring(1);
        if ((s.charAt(0) == '+') || (s.charAt(0) == '-')) s = s.substring(1);
        if (s.isEmpty()) return false;
        if (isDigit(s.charAt(0))) {
            s = reduceNumeric(s);
            if (s.isEmpty()) return true;
            if (s.charAt(0) == '.') s = reduceNumeric(s.substring(1));
            if (s.isEmpty()) return true;
        }
        else {
            if (s.charAt(0) == '.') {
                s = s.substring(1);
                if (s.isEmpty()) return false;
                if (!isDigit(s.charAt(0))) return false;
                s = reduceNumeric(s);
                if (s.isEmpty()) return true;
            }
            else return false;
        }
        if ((s.charAt(0) == 'e') || (s.charAt(0) == 'E')) {
            s = s.substring(1);
            if (s.isEmpty()) return false;
            if ((s.charAt(0) == '+') || (s.charAt(0) == '-')) s = s.substring(1);
            if (s.isEmpty()) return false;
            s = reduceNumeric(s);
            return s.isEmpty();
        }
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isNumber("6+1"));
    }
}
