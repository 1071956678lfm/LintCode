package leet.Solution2019_2;

//81
public class SearchRotatedArr {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

     (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

     You are given a target value to search. If found in the array return true, otherwise return false.

     Example 1:

     Input: nums = [2,5,6,0,0,1,2], target = 0
     Output: true
     Example 2:

     Input: nums = [2,5,6,0,0,1,2], target = 3
     Output: false
     * */
    public boolean search(int[] nums, int target) {
        return search(nums,target,0,nums.length-1);
    }

    private boolean search(int[] nums, int target, int left, int right) {
        
        return false;
    }
}
