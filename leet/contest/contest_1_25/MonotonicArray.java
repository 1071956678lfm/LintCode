package leet.contest.contest_1_25;

/**
 * 896
 */
public class MonotonicArray {
    /**
     * An array is monotonic if it is either monotone increasing or monotone decreasing.
     * <p>
     * An array A is monotone increasing if for all i <= j, A[i] <= A[j].
     * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
     * <p>
     * Return true if and only if the given array A is monotonic.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,2,3]
     * Output: true
     * Example 2:
     * <p>
     * Input: [6,5,4,4]
     * Output: true
     * Example 3:
     * <p>
     * Input: [1,3,2]
     * Output: false
     * Example 4:
     * <p>
     * Input: [1,2,4,5]
     * Output: true
     * Example 5:
     * <p>
     * Input: [1,1,1]
     * Output: true
     */
    public boolean isMonotonic(int[] A) {
        boolean upward = false;
        boolean flag = true;
        int size = A.length;
        if (size <= 1)
            return true;
        int begin = 0;
        int end = 1;

        while (flag && end < size) {
            if (A[begin] < A[end]) {
                upward = true;
                flag = false;
            } else if (A[begin] > A[end]) {
                upward = false;
                flag = false;
            } else {
                ++begin;
                ++end;
            }

        }
        while (end < size) {
            if (A[begin] == A[end]) {
                ++end;
                ++begin;
            } else if (A[begin] > A[end]) {
                if (upward)
                    return false;
                else {
                    ++begin;
                    ++end;
                }
            } else {
                if (!upward)
                    return false;
                else {
                    ++begin;
                    ++end;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        System.out.println(new MonotonicArray().isMonotonic(nums));
    }
}
