package leet.Answer2019_3;

//907
public class SumSubArr {
    /**
     * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
     * <p>
     * Since the answer may be large, return the answer modulo 10^9 + 7.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [3,1,2,4]
     * Output: 17
     * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
     * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
     */
    public int sumSubarrayMins(int[] A) {
        long ans = 0;
        long module = (long) (Math.pow(10, 9) + 7);
        for (int i = 0; i < A.length; ++i) {
            int tmpMin = Integer.MAX_VALUE;
            for (int j = i; j < A.length; ++j) {
                if (A[j] < tmpMin) {
                    tmpMin = A[j];
                }
                ans += tmpMin;
            }
        }
        return (int) (ans % module);
    }
}
