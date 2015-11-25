import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private final int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

    private class Trie {

        private Map<Character, Trie> children;

        private boolean ifWord;

        public Trie() {
            this.children = new HashMap<>();
            ifWord = false;
        }

        public void Insert(String word) {
            if (word.isEmpty()) {
                ifWord = true;
                return;
            }
            char c = word.charAt(0);
            if (children.containsKey(c))
                children.get(c).Insert(word.substring(1));
            else {
                Trie newTrie = new Trie();
                newTrie.Insert(word.substring(1));
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

    private void DFS(int x, int y, char[][] board, boolean[][] visited, String curr, Trie root, List<String> ans) {
        if (root.ifWord) {
            root.ifWord = false;
            ans.add(curr);
        }
        visited[x][y] = true;
        for (int i = 0;i < 4;i++) {
            int _x = x + dir[i][0];
            int _y = y + dir[i][1];
            if ((_x >= 0) && (_y >= 0) && (_x < visited.length) && (_y < visited[0].length)) {
                if ((!visited[_x][_y]) && root.contains(board[_x][_y]))
                    DFS(_x, _y, board, visited, curr + board[_x][_y], root.getChild(board[_x][_y]), ans);
            }
        }
        visited[x][y] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word: words) root.Insert(word);
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][];
        for (int i = 0;i < h;i++) {
            visited[i] = new boolean[w];
            for (int j = 0;j < w;j++) visited[i][j] = false;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0;i < h;i++)
            for (int j = 0;j < w;j++)
                if (root.contains(board[i][j]))
                    DFS(i, j, board, visited, "" + board[i][j], root.getChild(board[i][j]), ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] words = new String[1];
        words[0] = "a";
        //String[] words = new String[] {"oath","pea","eat","rain"};
        //char[][] board = new char[][] {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        char[][] board = new char[][] {{'a', 'a'}};
        System.out.println(new Solution().findWords(board, words));
    }
}