package leet.Solution2019_2;

//81
public class SearchRotatedArr {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
     * <p>
     * You are given a target value to search. If found in the array return true, otherwise return false.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     * Example 2:
     * <p>
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     * Output: false
     */
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private boolean search(int[] nums, int target, int left, int right) {
        int center;
        while (left < right) {
            center = (left + right) / 2;
            if (nums[center] == target || nums[left] == target || nums[right] == target)
                return true;
            else if (nums[center] < nums[right]) { // upwards from center -> right. 7 1 2 [4] 4 5 6
                if (nums[center] < target && target < nums[right])
                    left = center + 1;
                else
                    right = center - 1;
            } else if (nums[center] > nums[left]) { //  2 3 [4] 5 0 2
                if (nums[center] > target && target > nums[left])
                    right = center - 1;
                else
                    left = center + 1;
            } else {                                 // 1 1 1 1 [1] 2 3 0 或 4 5 1 2 [3] 3 3
                return search(nums, target, center + 1, right) || search(nums, target, left, center - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchRotatedArr().search(new int[]{1, 3, 1, 1, 1}, 3));
    }
}
