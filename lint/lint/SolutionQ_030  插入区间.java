package lint

��;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SolutionQ_030 {
	/*
	 * @param intervals: Sorted interval list.
	 * 
	 * @param newInterval: new interval.
	 * 
	 * @return: A new interval list.
	 */
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int start = newInterval.start;
		int end = newInterval.end;
		ListIterator<Interval> iterator = intervals.listIterator();
		if (intervals.size() == 0)
			iterator.add(newInterval);
		while (iterator.hasNext()) {
			Interval interval = iterator.next();
			if (end < interval.start) {
				iterator.previous();
				iterator.add(new Interval(start, end));
				return intervals;
			}
			if (start > interval.end) {
				if (iterator.hasNext())
					continue;
				else {
					iterator.add(new Interval(start, end));
				}
			} else {
				start = start < interval.start ? start : interval.start;
				end = end > interval.end ? end : interval.end;
				iterator.remove();
				if (intervals.size() == 0||!iterator.hasNext()) {
					iterator.add(new Interval(start, end));
					continue;
				}
			}
		}

		return intervals;
	}
}

class TestQ_030 {
	public static void main(String[] args) throws Exception {

		List<Interval> list = new ArrayList<>();

		list.add(new Interval(1, 5));
		list.add(new Interval(6, 8));
		SolutionQ_030.insert(list, new Interval(2, 7));
		System.out.println(list);
	}
}

class Interval {
	int start, end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
