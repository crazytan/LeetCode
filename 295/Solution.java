import java.util.*;

public class Solution {

    static class MedianFinder {

        private PriorityQueue<Integer> minHeap;

        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<Integer>((o1, o2) -> {
                return o2 - o1;
            });
        }

        public void addNum(int num) {
            if (minHeap.isEmpty()) {
                minHeap.add(num);
                return;
            }
            if (num >= minHeap.peek()) {
                if (minHeap.size() == maxHeap.size()) minHeap.add(num);
                else {
                    int tmp = minHeap.poll();
                    minHeap.add(num);
                    maxHeap.add(tmp);
                }
            }
            else {
                if (minHeap.size() > maxHeap.size()) maxHeap.add(num);
                else {
                    if (num >= maxHeap.peek()) minHeap.add(num);
                    else {
                        int tmp = maxHeap.poll();
                        minHeap.add(tmp);
                        maxHeap.add(num);
                    }
                }
            }
        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size()) return minHeap.peek();
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    };

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        for (int i = 1;i <= 10;i++) {
            finder.addNum(i);
            System.out.println(finder.findMedian());
        }
    }
}