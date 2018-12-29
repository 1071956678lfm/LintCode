package Ë¢Ìâ;

public class SolutionQ_041 {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	public static int maxSubArray(int[] nums) {
		return Method_4(nums, 0, nums.length - 1);
	}

	// O(nlog(n))
	private static int Method_4(int[] nums, int left, int right) {
		int maxLeftSum, maxRightSum;
		int maxLeftBorderSum = 0, maxRightBorderSum = 0;
		int leftBorderSum = 0, rightBorderSum = 0;
		int center;

		if (left == right) // base case
			if (nums[left] > 0)
				return nums[left];
			else
				return nums[0];

		center = (left + right) / 2;
		maxLeftSum = Method_4(nums, left, center);
		maxRightSum = Method_4(nums, center + 1, right);

		for (int i = center; i >= left; i--) {
			leftBorderSum += nums[i];
			if (leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}
		for (int i = center + 1; i <= right; i++) {
			rightBorderSum += nums[i];
			if (rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}
		return max3(maxRightSum, maxLeftSum, maxLeftBorderSum + maxRightBorderSum);

	}

	private static int max3(int a, int b, int c) {
		if (a > b) {
			if (a > c)
				return a;
			else
				return c;
		} else {
			if (b > c)
				return b;
			else
				return c;
		}

	}

	// O(n) online-algorithm
	@SuppressWarnings("unused")
	private static int Method_3(int[] nums) {
		int tmpSum, maxSum;
		int N = nums.length;
		tmpSum = 0;
		maxSum = -2000000;
		for (int j = 0; j < N; j++) {
			tmpSum += nums[j];
			if (tmpSum > maxSum)
				maxSum = tmpSum;
			if (tmpSum < 0)
				tmpSum = 0;
		}
		return maxSum;
	}

	// O(n^2)
	@SuppressWarnings("unused")
	private int Method_2(int[] nums) {
		int tmpSum, MaxSum;
		int N = nums.length;
		MaxSum = 0;
		for (int i = 0; i < N; i++) {
			tmpSum = 0;
			for (int j = i; j < N; j++) {
				tmpSum += nums[j];
				if (tmpSum > MaxSum)
					MaxSum = tmpSum;
			}
		}

		return MaxSum;
	}

	// O(n^3)
	@SuppressWarnings("unused")
	private int Method_1(int[] nums) {
		int tmpSum, MaxSum;
		int N = nums.length;
		MaxSum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				tmpSum = 0;
				for (int k = i; k <= j; k++)
					tmpSum += nums[k];
				if (tmpSum > MaxSum)
					MaxSum = tmpSum;
			}
		}
		return MaxSum;
	}
}

class Test_041 {
	public static void main(String[] args) {
		int[] nums = { -4, 5, -4, 5, -4, 5, -4, 5, -4, 5, -4, 5, -4, 5, -4, 5, -4, 5, -1000 };
		System.out.println(SolutionQ_041.maxSubArray(nums));
	}
}