package leet.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 448
 */
public class NumberDispappear {
    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
     * some elements appear twice and others appear once.
     * <p>
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     * <p>
     * Could you do it without extra space and in O(n) runtime?
     * You may assume the returned list does not count as extra space.
     * <p>
     * Example:
     * <p>
     * Input:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * Output:
     * [5,6]
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        return solutionB(nums);
    }

    /**
     * space complexity O(N)
     */
    private List<Integer> solutionA(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            tmp[i] = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i] - 1] = 1;
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (tmp[i] == 0)
                result.add(i + 1);
        }
        return result;
    }

    private List<Integer> solutionB(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        int index;
        for (int i = 0; i < len; i++) {
            index = nums[i];
            while (index != 0) {
                int temp = nums[index - 1];
                nums[index - 1] = 0;
                index = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = new NumberDispappear().findDisappearedNumbers(nums);
    }
}
