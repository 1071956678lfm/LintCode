package leet.Answer2019_3;

//992
public class _Subarr {
    /**
     * Given an array A of positive integers,
     * call a (contiguous, not necessarily distinct)
     * subarray of A good if the number of different integers in that subarray is exactly K.
     * <p>
     * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
     * <p>
     * Return the number of good subarrays of A.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: A = [1,2,1,2,3], K = 2
     * Output: 7
     * Explanation: Subarrays formed with exactly 2 different integers:
     * [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
     * Example 2:
     * <p>
     * Input: A = [1,2,1,3,4], K = 3
     * Output: 3
     * Explanation: Subarrays formed with exactly 3 different integers:
     * [1,2,1,3], [2,1,3], [1,3,4].
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        int[] dp = new int[A.length];
        if (K == 1) return A.length;
        dp[0] = 0;
        return 1;

    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
    }
}
