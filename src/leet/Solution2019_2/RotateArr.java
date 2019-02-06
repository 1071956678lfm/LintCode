package leet.Solution2019_2;

//189
public class RotateArr {
    /**
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,4,5,6,7] and k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * Example 2:
     * <p>
     * Input: [-1,-100,3,99] and k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     */
    public void rotate(int[] nums, int k) {
        int n = k % nums.length;
        int[] ans = new int[nums.length];
        for (int i = n - 1; i >= 0; --i) {
            ans[n - i] = nums[nums.length - 1 - i];
        }
        System.arraycopy(nums, 0, ans, n, nums.length - n);
        System.arraycopy(ans, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        new RotateArr().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
