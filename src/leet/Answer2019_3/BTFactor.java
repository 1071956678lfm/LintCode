package leet.Answer2019_3;

import java.util.*;

//823
public class BTFactor {
    /**
     * Given an array of unique integers, each integer is strictly greater than 1.
     * <p>
     * We make a binary tree using these integers and each number may be used for any number of times.
     * <p>
     * Each non-leaf node's value should be equal to the product of the values of it's children.
     * <p>
     * How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.
     * <p>
     * Example 1:
     * <p>
     * Input: A = [2, 4]
     * Output: 3
     * Explanation: We can make these trees: [2], [4], [4, 2, 2]
     * Example 2:
     * <p>
     * Input: A = [2, 4, 5, 10]
     * Output: 7
     * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
     */
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[A.length];
        int mod = 1000000007;
        for (int i = 0; i < A.length; ++i)
            map.put(A[i], i);
        Arrays.fill(dp, 1);
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) {  //i is left node
                    int factor = A[i] / A[j];
                    if (map.keySet().contains(factor)) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(factor)]) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for (long num : dp)
            ans += num;
        return (int) (ans % mod);
    }

    private int run(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (long x : dp) ans += x;
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        int[] nums = {2, 4};
        System.out.println(new BTFactor().numFactoredBinaryTrees(nums));
    }
}
