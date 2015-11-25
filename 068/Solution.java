import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private int findMax(int now, String[] words, int maxWidth) {
        int sum = words[now].length();
        int end = now + 1;
        while (end < words.length) {
            if ((sum + 1 + words[end].length() <= maxWidth)) {
                sum += 1 + words[end].length();
                end += 1;
            }
            else break;
        }
        return end;
    }

    private void appendSpace(StringBuilder line, int numSpace) {
        for (int i = 0;i < numSpace;i++)
            line.append(' ');
    }

    private String format(int now, int end, String[] words, int maxWidth) {
        StringBuilder line = new StringBuilder();
        int numSpace = maxWidth;
        for (int i = now;i < end;i++)
            numSpace -= words[i].length();
        if ((now + 1) >= end) {
            line.append(words[now]);
            appendSpace(line, numSpace);
            return line.toString();
        }
        if (end >= words.length) {
            for (int i = now;i < end;i++) {
                line.append(words[i]);
                line.append(' ');
            }
            appendSpace(line, maxWidth - line.length());
            return line.toString();
        }
        int extra = numSpace % (end - now - 1);
        int base = numSpace / (end - now - 1);
        for (int i = now;i < (end - 1);i++) {
            line.append(words[i]);
            appendSpace(line, base);
            if (extra > 0) {
                line.append(' ');
                extra--;
            }
        }
        line.append(words[end - 1]);
        return line.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (maxWidth == 0) {
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        int now = 0;
        int len = words.length;
        List<String> ans = new ArrayList<>();
        while (now < len) {
            int end = findMax(now, words, maxWidth);
            ans.add(format(now, end, words, maxWidth));
            now = end;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fullJustify(new String[] {"a","b","c"}, 1));
        /*System.out.println(new Solution().fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));*/
    }
}
