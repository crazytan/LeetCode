import java.util.*;

public class Solution {

    private void addPath(String beginWord, String now, Map<String, List<String>> prev, List<List<String>> ans, List<String> path) {
        if (now.equals(beginWord)) {
            //ans.add(Arrays.asList(path.substring(1).split(" ")));
            ans.add(path);
            return;
        }
        if (!prev.get(now).isEmpty()) {
            prev.get(now).stream().forEach(word -> {
                List<String> _path = new ArrayList<String>(path);
                _path.add(0, word);
                addPath(beginWord, word, prev, ans, _path);
            });
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);

        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 0);
        wordList.stream().forEach(word -> dist.put(word, Integer.MAX_VALUE));

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        Map<String, List<String>> prev = new HashMap<>();
        wordList.stream().forEach(word -> prev.put(word, new ArrayList<>()));

        while (!queue.isEmpty()) {
            String now = queue.poll();
            if (now.equals(endWord)) break;

            char[] chars = now.toCharArray();
            for (int i = 0;i < chars.length;i++) {
                for (char newChar = 'a';newChar <= 'z';newChar++) {
                    chars[i] = newChar;
                    String next = new String(chars);
                    if (!next.equals(now) && wordList.contains(next)) {
                        if (dist.get(now) + 1 < dist.get(next)) {
                            dist.put(next, dist.get(now) + 1);
                            prev.get(next).clear();
                            prev.get(next).add(now);
                            queue.add(next);
                        }
                        else if (dist.get(now) + 1 == dist.get(next)) {
                            prev.get(next).add(now);
                        }
                    }
                }
                chars[i] = now.charAt(i);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(endWord);
        addPath(beginWord, endWord, prev, ans, path);
        return ans;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        Set<String> list = new HashSet<>();
        list.add("hot");
        list.add("dog");
        list.add("dot");
        list.add("lot");
        list.add("log");

        List<List<String>> paths = new Solution().findLadders(begin, end, list);
        paths.stream().forEach(System.out::println);
    }
}
