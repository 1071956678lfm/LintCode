package leet.Solution2019_2;

//313
public class SuperUglyNumber {
    /**
     * Write a program to find the nth super ugly number.
     * <p>
     * Super ugly numbers are positive numbers whose all
     * prime factors are in the given prime list primes of size k.
     * <p>
     * Example:
     * <p>
     * Input: n = 12, primes = [2,7,13,19]
     * Output: 32
     * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
     * super ugly numbers given primes = [2,7,13,19] of size 4.
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] cursor = new int[primes.length];
        for (int i = 1; i < n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < primes.length; ++k) {
                min = Math.min(min, dp[cursor[k]] * primes[k]);
            }
            dp[i] = min;
            for (int k = 0; k < primes.length; ++k) {
                if (min == dp[cursor[k]] * primes[k])
                    ++cursor[k];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 13, 19};
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(12, nums));
    }
}
