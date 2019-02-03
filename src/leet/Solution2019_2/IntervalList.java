package leet.Solution2019_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalList {
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
     * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
     * <p>
     * Return the intersection of these two interval lists.
     * <p>
     * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
     * The intersection of two closed intervals is a set of real numbers that is either empty,
     * or can be represented as a closed interval.
     * <p>
     * For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
     */
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i].start, B[j].start);
            int hi = Math.min(A[i].end, B[j].end);
            if (lo <= hi)
                ans.add(new Interval(lo, hi));

            // Remove the interval with the smallest endpoint
            if (A[i].end < B[j].end)
                i++;
            else
                j++;
        }

        return ans.toArray(new Interval[ans.size()]);
    }

    public static void main(String[] args) {
        Interval[] A = new Interval[]{
                new Interval(8, 15),
        };
        Interval[] B = new Interval[]{
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(12, 20)
        };
        System.out.println(Arrays.toString(new IntervalList().intervalIntersection(A, B)));
    }
}
