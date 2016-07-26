import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        Collections.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        List<Interval> ans = new ArrayList<>();
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > end) {
                ans.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            } else {
                if (intervals.get(i).end > end) {
                    end = intervals.get(i).end;
                }
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.merge(new ArrayList<Interval>(Arrays.asList(
                new Interval[]{ s.new Interval(1, 3)}))));
    }
}