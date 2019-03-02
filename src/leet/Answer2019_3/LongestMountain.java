package leet.Answer2019_3;

//845
public class LongestMountain {
    /**
     * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
     * <p>
     * B.length >= 3
     * There exists some 0 < i < B.length - 1
     * such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
     * (Note that B could be any subarray of A, including the entire array A.)
     * <p>
     * Given an array A of integers, return the length of the longest mountain.
     * <p>
     * Return 0 if there is no mountain.
     * <p>
     * Example 1:
     * <p>
     * Input: [2,1,4,7,3,2,5]
     * Output: 5
     * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
     * Example 2:
     * <p>
     * Input: [2,2,2]
     * Output: 0
     * Explanation: There is no mountain.
     */
    public int longestMountain(int[] A) {
        int max = 0;
        int start = -1; //if start = -1 , then not begin to count
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                // increasing
                if (start == -1)
                    start = i - 1;
            } else if (A[i - 1] == A[i]) {
                // flat
                start = -1;
            } else {
                // decreasing
                if (start != -1)
                    max = Math.max(max, i - start + 1);
                // if next one is increasing, then reset
                if (i < A.length - 1 && A[i] < A[i + 1])
                    start = -1;
            }
        }
        return max;
    }
}
