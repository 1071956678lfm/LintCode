package leet.Solution2019_2;

//416
public class PartitionTwo {
    /**
     * Given a non-empty array containing only positive integers,
     * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1]; //数字i 是否是nums的某些元素的和
        for (int i = 0; i < target + 1; ++i)
            dp[i] = false;
        dp[0] = true;
        for (int num : nums) {
            //每一个num都更新dp数组
            for (int i = target; i >= num; --i) {
                dp[i] = dp[i]           //如果本身就是和
                        | dp[i - num];  //如果和是i 且i-num这个和存在
            }
        }
        return dp[target];
    }
}
