import java.util.*;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.isEmpty() || (words.length <= 0) || (words[0].isEmpty())) return ans;

        int wl = words[0].length();
        int l = words.length * wl;
        Map<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0;i < words.length;i++) wordsMap.put(words[i], wordsMap.getOrDefault(words[i], 0) + 1);

        for (int i = 0;i <= (s.length() - l);i++) {
            if (wordsMap.getOrDefault(s.substring(i, i + wl), 0) > 0) {
                Map<String, Integer> _map = new HashMap<>();
                _map.put(s.substring(i, i + wl), 1);
                int index = i + wl;
                if ((index - i) >= l) {
                    ans.add(i);
                    continue;
                }
                String tmp = s.substring(index,index + wl);
                while (wordsMap.containsKey(tmp) && (_map.getOrDefault(tmp, 0) < wordsMap.get(tmp))) {
                    _map.put(tmp, _map.getOrDefault(tmp, 0) + 1);
                    index += wl;
                    if ((index - i) >= l)  {
                        ans.add(i);
                        break;
                    }
                    tmp = s.substring(index, index + wl);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
        System.out.println(new Solution().findSubstring("a", new String[] {"a"}));
    }
}