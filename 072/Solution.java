public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        int l1 = word1.length(), l2 = word2.length();
        int[][] f = new int[l1 + 1][l2 + 1];
        f[0][0] = 0;
        for (int i = 1; i <= l1; i++) f[i][0] = i;
        for (int i = 1; i <= l2; i++) f[0][i] = i;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                f[i][j] = Math.min(f[i-1][j] + 1, f[i][j-1] + 1);
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
                } else {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }
        return f[l1][l2];
    }
}
