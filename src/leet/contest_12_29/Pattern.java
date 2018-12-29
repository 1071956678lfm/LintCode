package leet.contest_12_29;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Pattern {
    /**
     * Given a sequence of n integers a1, a2, ..., an,
     * a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
     * Design an algorithm that takes a list of n numbers as input
     * and checks whether there is a 132 pattern in the list.
     * <p>
     * Note: n will be less than 15,000.
     * <p>
     * Input: [1, 2, 3, 4]
     * <p>
     * Output: False
     * <p>
     * Explanation: There is no 132 pattern in the sequence.
     */
    public boolean find132pattern(int[] nums) {
        /*
         * use one stack
         * */
        if (nums == null) return false;
        int n = nums.length;
        if (n < 3) return false;

        Stack<Integer> s = new Stack<>();
        int knum = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < knum) return true;
            while (!s.isEmpty() && nums[i] > s.peek()) {
                knum = s.pop();
            }
            s.add(nums[i]);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, 1, -4, -3};
        boolean result = new Pattern().find132pattern(nums);
        System.out.println(result);
    }
}
