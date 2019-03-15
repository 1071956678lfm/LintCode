package leet.Sum;

import java.util.*;

/**
 * 56
 */
public class MergeIntervals {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     * <p>
     * Input: [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1)
            return intervals;
        List<Interval> ans = new LinkedList<>();
        intervals.sort(Comparator.comparingInt(a -> a.start));
        int index = 1;
        Interval baseInterval = intervals.get(0);
        while (index < intervals.size()) {
            Interval next = intervals.get(index);
            if (baseInterval.end < next.start) { //insert the base
                ans.add(baseInterval);
                baseInterval = next;
                ++index;
            } else {//not insert , merge first
                baseInterval.end = Math.max(baseInterval.end, next.end);
                ++index;
            }
        }
        ans.add(baseInterval);
        return ans;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        new MergeIntervals().merge(intervals);
    }
}
