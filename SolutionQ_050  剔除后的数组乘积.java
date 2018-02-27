package Ë¢Ìâ;

import java.util.ArrayList;
import java.util.List;

public class SolutionQ_50 {
	/*
	 * @param nums: Given an integers array A
	 * 
	 * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... *
	 * A[n-1]
	 */
	public List<Long> productExcludeItself(List<Integer> nums) {
		return Method_2(nums);
	}

	private List<Long> Method_2(List<Integer> nums) {

		return null;
	}

	/**
	 * @param nums
	 * @return
	 */
	public List<Long> Method_1(List<Integer> nums) {
		int len = nums.size();
		List<Long> results = new ArrayList<Long>();
		for (int i = 0; i < len; i++) {
			long result = 1;
			for (int j = 0; j < len; j++) {
				if (i != j)
					result *= nums.get(j);
			}
			results.add(result);
		}
		return results;
	}
}