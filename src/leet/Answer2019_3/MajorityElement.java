package leet.Answer2019_3;

import java.util.*;

//229
public class MajorityElement {
    /**
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     * <p>
     * Note: The algorithm should run in linear time and in O(1) space.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,2,3]
     * Output: [3]
     * Example 2:
     * <p>
     * Input: [1,1,1,3,3,2,2,2]
     * Output: [1,2]
     * <p>
     * At most 3 results
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        int bound = nums.length / 3; //more than bound
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length == 0)
            return ans;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int n : map.keySet()) {
            if (map.get(n) > bound)
                ans.add(n);
        }
        return ans;
    }
}
