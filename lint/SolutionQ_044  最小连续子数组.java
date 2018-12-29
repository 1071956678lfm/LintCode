package Ë¢Ìâ;

import java.util.List;

public class SolutionQ_044 {
	/*
	 * @param nums: a list of integers
	 * 
	 * @return: A integer indicate the sum of minimum subarray
	 */
	public int minSubArray(List<Integer> nums) {
		return method_1(nums);
	}

	private int method_3(List<Integer> nums, int left, int right) {
		
		
		return 0;
	}

	private int method_2(List<Integer> nums) {
		int tmpSum, maxSum = nums.get(0);
		tmpSum=0;
		for(int i=0;i<nums.size();i++) {
			tmpSum+=nums.get(i);
			if(tmpSum<maxSum)
				maxSum=tmpSum;
			if(tmpSum>0)
				tmpSum=0;
		}
		return maxSum;
	}

	private int method_1(List<Integer> nums) {
		int tmpSum, maxSum = nums.get(0);
		for (int i = 0; i < nums.size(); i++) {
			tmpSum = 0;
			for (int j = i; j < nums.size(); j++) {
				tmpSum += nums.get(j);
				if (tmpSum < maxSum)
					maxSum = tmpSum;
			}

		}
		return maxSum;
	}
}

class Test_44 {
	public static void main(String[] args) {

	}
}