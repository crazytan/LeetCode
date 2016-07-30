public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        Deque<Integer> heightStack = new ArrayDeque<>();
        Deque<Integer> indexStack = new ArrayDeque<>();
        int ans = 0;
        heightStack.addLast(0);
        indexStack.addLast(-1);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] >= heightStack.peekLast()) {
                heightStack.addLast(heights[i]);
                indexStack.addLast(i);
            } else {
                while (!heightStack.isEmpty() && (heightStack.peekLast() > heights[i])) {
                    int height = heightStack.pollLast();
                    indexStack.pollLast();
                    if (height * (i - indexStack.peekLast() - 1) > ans) ans = height * (i - indexStack.peekLast() - 1);
                }
                heightStack.addLast(heights[i]);
                indexStack.addLast(i);
            }
        }
        int min = 0;
        heightStack.pollFirst();
        indexStack.pollFirst();
        while (!heightStack.isEmpty()) {
            if ((heights.length - min) * heightStack.peekFirst() > ans) {
                ans = (heights.length - min) * heightStack.peekFirst();
            }
            min = indexStack.pollFirst() + 1;
            heightStack.pollFirst();
        }
        return ans;
    }
}
