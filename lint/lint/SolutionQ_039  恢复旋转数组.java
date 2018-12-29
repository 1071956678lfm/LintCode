package lint

��;

import java.util.List;

public class SolutionQ_039 {
	/*
	 * @param nums: An integer array
	 * 
	 * @return: nothing
	 */
	public void recoverRotatedSortedArray(List<Integer> nums) {
		Integer tmp = nums.get(0);
		int count;
		for (count = 0; count < nums.size(); count++) {
			if (nums.get(count) < tmp)
				break;
		}
		if (count != nums.size()) {
			for (int j = 0; j < count; j++)
				nums.add(nums.get(j));
			nums.subList(0, count).clear();
		}
	}
}

class Test_Q39 {
	public static void main(String[] args) {

	}
}