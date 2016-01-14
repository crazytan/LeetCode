import java.util.*;

public class Solution {

    private class Trie {

        private Map<Character, Trie> children;

        private boolean ifWord;

        public Trie() {
            this.children = new HashMap<>();
            ifWord = false;
        }

        public void insert(String word) {
            if (word.isEmpty()) {
                ifWord = true;
                return;
            }
            char c = word.charAt(0);
            if (children.containsKey(c))
                children.get(c).insert(word.substring(1));
            else {
                Trie newTrie = new Trie();
                newTrie.insert(word.substring(1));
                children.put(c, newTrie);
            }
        }

        public boolean contains(char c) {
            return children.containsKey(c);
        }

        public Trie getChild(char c) {
            return children.getOrDefault(c, null);
        }
    }

    private boolean _break(String curr, String s, Trie root, Trie node, List<String> ans) {
        if (node.ifWord) {
            if (s.isEmpty()) return true;
            if (_break(curr + " ", s, root, root, ans)) return true;
        }
        if (s.isEmpty()) return false;
        if (node.contains(s.charAt(0))) {
            if (_break(curr + s.charAt(0), s.substring(1), root, node.getChild(s.charAt(0)), ans))
                return true;
        }
        return false;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        while (wordDict.contains("")) wordDict.remove("");
        List<String> ans = new ArrayList<>();
        if (s.isEmpty()) return true;

        boolean found = false;
        for (String word: wordDict) {
            if (word.length() <= s.length()) {
                if (s.lastIndexOf(word) == (s.length() - word.length())) {
                    found = true;
                    break;
                }
            }
        }
        if (!found) return false;

        Trie root = new Trie();
        for (String word: wordDict) root.insert(word);
        return _break("", s, root, root, ans);
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("cod");
        System.out.println(new Solution().wordBreak("leetcode", set));
    }
}