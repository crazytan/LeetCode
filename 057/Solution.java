import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    private void merge(List<Interval> intervals, Interval newInterval, int startIndex, int endIndex) {
        int newStart = newInterval.start < intervals.get(startIndex).start ? newInterval.start : intervals.get(startIndex).start;
        int newEnd = newInterval.end > intervals.get(endIndex).end ? newInterval.end : intervals.get(endIndex).end;
        for (int i = startIndex; i <= endIndex; i++) {
            intervals.remove(startIndex);
        }
        intervals.add(startIndex, new Interval(newStart, newEnd));
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            return new ArrayList<>(Arrays.asList(new Interval[] {newInterval}));
        }
        int n = intervals.size();
        int startIndex = -1;
        for (int i = 0; i < n; i++) {
            if (startIndex > -1) {
                if (newInterval.end < intervals.get(i).start) {
                    merge(intervals, newInterval, startIndex, i - 1);
                    return intervals;
                }
                if (newInterval.end <= intervals.get(i).end) {
                    merge(intervals, newInterval, startIndex, i);
                    return intervals;
                }
            } else {
                if (newInterval.end < intervals.get(i).start) {
                    intervals.add(i, newInterval);
                    return intervals;
                }
                if (newInterval.start <= intervals.get(i).end) {
                    startIndex = i;
                }
            }
        }
        if (startIndex == -1) {
            intervals.add(n, newInterval);
        } else {
            merge(intervals, newInterval, startIndex, n - 1);
        }
        return intervals;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.insert(new ArrayList<>(Arrays.asList(new Interval[] {
                s.new Interval(3,4)
        })),  s.new Interval(4,9)));
    }
}