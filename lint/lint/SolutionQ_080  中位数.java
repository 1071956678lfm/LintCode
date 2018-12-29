package lint

��;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SolutionQ_080 {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: An integer denotes the middle number of the array
	 */
	public int median(int[] nums) {
		List<Integer> list = new LinkedList<Integer>();
		int len = nums.length;
		int index = (len % 2 == 0) ? len / 2 : len / 2 + 1;
		for (int i = 0; i < len; i++) {
			list.add(nums[i]);
		}
		list.sort(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		return list.get(index);
	}
}

class Test {
	public static void main(String[] args) {

	}
}