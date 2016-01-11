import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if ((pattern == null) || (str == null)) return false;
        if (pattern.isEmpty() && !str.isEmpty()) return false;
        if (str.isEmpty() && !pattern.isEmpty()) return false;
        HashMap<Character, String> map = new HashMap<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        for (int i = 0;i < pattern.length();i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(words[i])) return false;
                map.put(pattern.charAt(i), words[i]);
            }
            else {
                if (!map.get(pattern.charAt(i)).equals(words[i])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
    }
}