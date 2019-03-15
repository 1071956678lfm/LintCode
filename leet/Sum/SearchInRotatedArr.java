package leet.Sum;

/**
 * 33
 */
public class SearchInRotatedArr {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     * <p>
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     */
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        int center;
        while (left <= right) {
            center = (left + right) / 2;
            if (nums[center] == target)
                return center;
            else if (nums[center] < nums[right]) { //The right part is ordered. like   6 7 8 0 [1] 2 3 4 5
                if (nums[center] < target && nums[right] >= target)
                    left = center + 1;
                else
                    right = center - 1;
            } else {
                if (nums[center] > target && nums[left] <= target)
                    right = center - 1;
                else
                    left = center + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new SearchInRotatedArr().search(nums, 0));
    }
}
