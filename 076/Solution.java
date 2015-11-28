import java.util.*;

public class Solution {

    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0;i < t.length();i++) {
            Character ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        int n = t.length();

        String ans = "";
        int l = s.length() + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Character, Integer> chMap = new HashMap<>();
        int cnt = 0;
        for (int i = 0;i < s.length();i++) {
            Character ch = s.charAt(i);
            int tCnt = tMap.getOrDefault(ch, 0);
            int chCnt = chMap.getOrDefault(ch, 0);
            if (tCnt > 0) {
                if (chCnt < tCnt) cnt++;
                queue.addLast(i);
                chMap.put(ch, chCnt + 1);
                if (cnt == n) {
                    Character _ch = s.charAt(queue.peekFirst());
                    while (chMap.get(_ch) > tMap.get(_ch)) {
                        queue.pollFirst();
                        chMap.put(_ch, chMap.get(_ch) - 1);
                        _ch = s.charAt(queue.peekFirst());
                    }
                    String _ans = s.substring(queue.peekFirst(), queue.peekLast() + 1);
                    if (_ans.length() < l) {
                        ans = _ans;
                        l = _ans.length();
                    }
                    _ch = s.charAt(queue.pollFirst());
                    chMap.put(_ch, chMap.get(_ch) - 1);
                    cnt--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("AABBCCBA", "ABC"));
    }
}