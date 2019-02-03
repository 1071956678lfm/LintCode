package leet.Solution2019_2;

//932
public class BeautifuArr {
    /**
     * For some fixed N, an array A is beautiful
     * if it is a permutation of the integers 1, 2, ..., N, such that:
     * <p>
     * For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].
     * <p>
     * Given N, return any beautiful array A.  (It is guaranteed that one exists.)
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: 4
     * Output: [2,1,4,3]
     * Example 2:
     * <p>
     * Input: 5
     * Output: [3,1,2,5,4]
     */
    public int[] beautifulArray(int N) {
        int[] ans = new int[N];
        for (int i = 1; i <= N; ++i)
            ans[i - 1] = i;


        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
