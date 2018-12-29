package Ë¢Ìâ;

public class Solution {
	/**
	 * @param nums:
	 *            The integer array.
	 * @param target:
	 *            Target to find.
	 * @return: The first position of target. Position starts from 0.
	 */
	public static int binarySearch(int[] nums, int target) {
		if (nums == null)
			return -1;

		int end = nums.length - 1;
		int begin = 0;
		int center = (begin + end) / 2;
		if (end < 0)
			return -1;
		while (begin < end) {
			center = (begin + end) / 2;
			if (nums[center] == target) {
				while(center!=0&&nums[center-1]==target)
					center--;
				return center;
			} else if (nums[center] > target)
				end = center - 1;
			else
				begin = center + 1;
		}
		center = (begin + end) / 2;
		if (nums[center] == target)
			return center;
		else
			return -1;

	}
}

class Test {
	public static void main(String[] args) {
		int[] str = {1,8,8,8,8,8,9};
		int tar = 8;
		System.out.println(Solution.binarySearch(str, tar));
	}
}
