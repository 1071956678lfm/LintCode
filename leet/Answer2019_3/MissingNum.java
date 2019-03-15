package leet.Answer2019_3;

import java.util.Arrays;

//268
public class MissingNum {
    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
     * find the one that is missing from the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,0,1]
     * Output: 2
     * Example 2:
     * <p>
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != ans)
                return ans;
            ++ans;
        }
        return -1;
    }
}
