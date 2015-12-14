import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    private boolean sameChars(String s1, String s2) {
        Character[] arr1 = s1.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Character[] arr2 = s2.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        List<Character> l1 = Arrays.asList(arr1);
        List<Character> l2 = Arrays.asList(arr2);
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }

    public boolean isScramble(String s1, String s2) {
        if ((s1 == null) && (s2 == null)) return true;
        if ((s1 == null) || (s2 == null)) return false;
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        if (s1.length() == 1) return false;
        if (!sameChars(s1, s2)) return false;
        for (int i = 1;i < s1.length();i++) {
            String s1_l = s1.substring(0, i);
            String s1_r = s1.substring(i);
            String s2_l = s2.substring(0, i);
            String s2_r = s2.substring(i);
            if (sameChars(s1_l, s2_l) && sameChars(s1_r, s2_r))
                if (isScramble(s1_l, s2_l) && isScramble(s1_r, s2_r)) return true;
            s2_l = s2.substring(0, s2.length() - i);
            s2_r = s2.substring(s2.length() - i);
            if (sameChars(s1_l, s2_r) && sameChars(s1_r, s2_l))
                if (isScramble(s1_l, s2_r) && isScramble(s1_r, s2_l)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isScramble("great", "rgaet"));
    }
}
