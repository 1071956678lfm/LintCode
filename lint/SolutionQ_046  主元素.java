package À¢Ã‚;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SolutionQ_046 {
	/*
	 * @param nums: a list of integers
	 * 
	 * @return: find a majority number
	 */
	public static int majorityNumber(List<Integer> nums) {
		return method_3(nums, 0, nums.size() - 1);
	}

	private static Integer method_3(List<Integer> nums, int left, int right) {
		int center = (left + right) / 2;
		if (left == right)
			return nums.get(center);
		Integer leftMajority = method_3(nums, left, center);
		Integer rightMajority = method_3(nums, center + 1, right);

		if (leftMajority != null && rightMajority != null) {
			int leftCount=0;
			int rightCount=0;
			for(int i=left;i<=center;i++) {
				if(nums.get(i)==leftMajority)
					leftCount++;
			}
			for(int i=center+1;i<=right;i++) {
				if(nums.get(i)==rightMajority)
					rightCount++;
			}
			
			if (leftCount >= rightCount)
				return leftMajority;
			else
				return rightMajority;
		}

		return 0;

	}

	@SuppressWarnings("unused")
	private static int method_2(List<Integer> nums) {
		int seed = nums.get(0);
		int count = 1;

		for (int i = 1; i < nums.size(); i++) {
			if (seed == nums.get(i))
				count++;
			else {
				if (count > 0)
					count--;
				else
					seed = nums.get(i);
			}
		}
		count = 0;
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) == seed)
				count++;
		}
		if (count > nums.size() / 2)
			return seed;
		return 0;
	}

	@SuppressWarnings("unused")
	private static int method_1(List<Integer> nums) {
		Map<Integer, Integer> countMap = new HashMap<>();
		countMap.put(nums.get(0), 1);
		for (int i = 1; i < nums.size(); i++) {

			Integer current = nums.get(i);
			if (!countMap.containsKey(current))
				countMap.put(current, 1);
			else {
				Integer value = countMap.get(current);
				value++;
				countMap.replace(current, value);
			}
		}
		Set<Entry<Integer, Integer>> result = countMap.entrySet();
		Iterator<Entry<Integer, Integer>> it = result.iterator();
		while (it.hasNext()) {
			Entry<Integer, Integer> values = it.next();
			if (values.getValue() > nums.size() / 2)
				return values.getKey();
		}
		return 0;

	}
}

class Test_46 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2);
		int i = SolutionQ_046.majorityNumber(list);
		System.out.println(i);
	}
}