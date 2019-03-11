package leet.Answer2019_3;

//493
public class ReversePairs {
    /**
     * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
     * <p>
     * You need to return the number of important reverse pairs in the given array.
     * <p>
     * Example1:
     * <p>
     * Input: [1,3,2,3,1]
     * Output: 2
     * Example2:
     * <p>
     * Input: [2,4,3,5,1]
     * Output: 3
     */
    public int reversePairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (isImportant(nums[i], nums[j]))
                    ++ans;
            }
        }
        return ans;
    }

    private boolean isImportant(int a, int b) {
        long la = (long) a;
        long lb = (long) b;
        return la > (lb << 1);
    }
}
