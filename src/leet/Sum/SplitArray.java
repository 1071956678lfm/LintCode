package leet.Sum;

/**
 * 410
 */
public class SplitArray {
    /**
     * Given an array which consists of non-negative integers and an integer m,
     * you can split the array into m non-empty continuous subarrays.
     * Write an algorithm to minimize the largest sum among these m subarrays.
     * <p>
     * Note:
     * If n is the length of array, assume the following constraints are satisfied:
     * <p>
     * 1 ≤ n ≤ 1000
     * 1 ≤ m ≤ min(50, n)
     * <p>
     * Examples:
     * <p>
     * Input:
     * nums = [7,2,5,10,8]
     * m = 2
     * <p>
     * Output:
     * 18
     * <p>
     * Explanation:
     * There are four ways to split nums into two subarrays.
     * The best way is to split it into [7,2,5] and [10,8],
     * where the largest sum among the two subarrays is only 18.
     */
    public int splitArray(int[] nums, int m) {
        long leftSum = 0;
        long rightSum = 0;
        for (int num : nums) {
            rightSum += num;
            leftSum = leftSum >= num ? leftSum : num;
        }
        long res = binSearch(nums, m, leftSum, rightSum);
        return (int) res;
    }

    private long binSearch(int[] nums, int m, long leftSum, long rightSum) {
        if (m == 1)
            return leftSum;
        if (m == nums.length)
            return rightSum;
        while (leftSum < rightSum) {
            long midSum = (leftSum + rightSum) / 2;
            if (isValid(nums, m, midSum)) {
                rightSum = midSum;
            } else {
                leftSum = midSum + 1;
            }
        }
        return rightSum;
    }

    /**
     * if we split k parts ,
     * if  k <= m , return true
     * else return false
     *
     * @param nums   :arr
     * @param m      :The partition counter
     * @param midSum :Target sum
     */
    private boolean isValid(int[] nums, int m, long midSum) {
        int counter = 1;
        long cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur + nums[i] <= midSum) {
                cur += nums[i];
            } else {
                counter++;
                cur = nums[i]; //refresh the cur
                if (counter > m) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 8, 10};
        System.out.println(new SplitArray().splitArray(nums, 2));
    }
}
