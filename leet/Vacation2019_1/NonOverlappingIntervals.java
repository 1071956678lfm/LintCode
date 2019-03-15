package leet.Vacation2019_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//435
public class NonOverlappingIntervals {
    private static class Interval {
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
     * Given a collection of intervals,
     * find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     * <p>
     * Note:
     * You may assume the interval's end point is always bigger than its start point.
     * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
     * Example 1:
     * Input: [ [1,2], [2,3], [3,4], [1,3] ]
     * <p>
     * Output: 1
     * <p>
     * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
     * Example 2:
     * Input: [ [1,2], [1,2], [1,2] ]
     * <p>
     * Output: 2
     * <p>
     * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
     * Example 3:
     * Input: [ [1,2], [2,3] ]
     * <p>
     * Output: 0
     * <p>
     * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
     */
    public int eraseOverlapIntervals(Interval[] intervals) {
        List<Interval> list = Arrays.asList(intervals);
        list.sort(Comparator.comparingInt(o -> o.start));
        boolean[] deleted = new boolean[intervals.length];
        for (int i = 0; i < deleted.length; ++i)
            deleted[i] = false;
        int ans = 0;
        for (int i = 0; i < intervals.length; ++i) {
            if (deleted[i])
                continue;
            Interval interval_i = list.get(i);
            int j = i + 1;
            while (j < intervals.length) {
                Interval interval_j = list.get(j);
                if (!deleted[j] && interval_i.end > interval_j.start) { //overlap
                    ++ans;
                    if (getRangeSize(interval_i) > getRangeSize(interval_j)) {
                        deleted[i] = true;
                        i = j;
                        break;
                    } else {
                        deleted[j] = true;
                        ++j;
                    }
                } else {//not overlap
                    ++j;
                }
            }
        }
        return ans;
    }

    private int getRangeSize(Interval a) {
        return a.end - a.start + 1;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
                new Interval(1, 2),
                new Interval(1, 2),
                new Interval(1, 2),
                new Interval(1, 2),
                new Interval(1, 2),
        };
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }
}
