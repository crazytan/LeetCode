import java.util.HashSet;
import java.util.Set;

public class Solution {

    private void infer(String word1, String word2, boolean[][] edge, int[] cnt) {
        int i = 0;
        while ((i < word1.length()) && (i < word2.length()) && (word1.charAt(i) == word2.charAt(i))) i++;
        if ((i >= word1.length()) || (i >= word2.length())) return;
        int c1 = word1.charAt(i) - 'a', c2 = word2.charAt(i) - 'a';
        if (!edge[c1][c2]) {
            edge[c1][c2] = true;
            cnt[c2]++;
        }
    }

    public String alienOrder(String[] words) {
        if ((words == null) || (words.length == 0)) return "";
        if (words.length == 1) return words[0];
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++)
                charSet.add(words[i].charAt(j));
        }
        boolean[][] edge = new boolean[26][26];
        int[] cnt = new int[26];
        for (int i = 0; i < (words.length - 1); i++) {
            infer(words[i], words[i + 1], edge, cnt);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!charSet.contains(ch)) cnt[ch - 'a'] = -1;
        }
        StringBuilder ans = new StringBuilder();
        while (true) {
            boolean found = false;
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (cnt[ch - 'a'] == 0) {
                    found = true;
                    cnt[ch - 'a'] = -1;
                    charSet.remove(ch);
                    ans.append(ch);
                    for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
                        if (edge[ch - 'a'][ch2 - 'a']) cnt[ch2 - 'a']--;
                    }
                }
            }
            if (!found) break;
        }
        if (charSet.isEmpty()) return ans.toString();
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().alienOrder(new String[] {
            "za", "zb", "ca", "cb"
        }));
    }
}
