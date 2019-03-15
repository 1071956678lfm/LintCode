package leet.Answer2019_3;

//523
public class ContinusSubArrSum {
    /**
     * Given a list of non-negative numbers and a target integer k,
     * write a function to check if the array has a continuous subarray of size
     * at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
     * <p>
     * Example 1:
     * Input: [23, 2, 4, 6, 7],  k=6
     * Output: True
     * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
     * Example 2:
     * Input: [23, 2, 6, 4, 7],  k=6
     * Output: True
     * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0) {
            if (nums.length == 1 && nums[0] == 0)
                return false;

            for (int num : nums) {
                if (num != 0)
                    return false;
            }
            return true;
        }
        for (int i = 0; i < nums.length; ++i) {
            int tmpSum = 0;
            for (int j = i + 1; j < nums.length; ++j) {
                tmpSum += nums[j];
                if (tmpSum % k == 0)
                    return true;
            }
        }
        return false;
    }
}
