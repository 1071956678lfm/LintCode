package Questions;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SolutionQ_156 {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        return challengedWay(intervals);

    }

    private List<Interval> challengedWay(List<Interval> intervals) {

        return null;
    }

    private List<Interval> normalWay(List<Interval> intervals) {
        // write your code here
        if (intervals.size() == 1) return intervals;
        int flag = 0;
        for (int index = 0; index < intervals.size(); index++) {
            if (flag == 1) {
                index--;
                flag = 0;
            }
            for (int j = index + 1; j < intervals.size(); j++) {

                int tmpBegin_1 = intervals.get(index).start;
                int tmpEnd_1 = intervals.get(index).end;
                int tmpBegin_2 = intervals.get(j).start;
                int tmpEnd_2 = intervals.get(j).end;
                if (tmpEnd_1 < tmpBegin_2 || tmpEnd_2 < tmpBegin_1) {
                } else {
                    Interval tmpInterval = intervals.get(index);
                    tmpInterval.start = Math.min(tmpBegin_1, tmpBegin_2);
                    tmpInterval.end = Math.max(tmpEnd_1, tmpEnd_2);
                    intervals.remove(j--);
                    flag = 1;
                }
            }
        }

        intervals.sort(Comparator.comparingInt(o -> o.start));
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> list = new LinkedList<>();
        list.add(new Interval(2, 3));
        list.add(new Interval(4, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 9));
        list.add(new Interval(1, 10));
        SolutionQ_156 solutionQ_156 = new SolutionQ_156();
        System.out.println(solutionQ_156.merge(list));
    }

}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}