package leet.CountPrime;

public class Solution {
    /**
     * Count the number of prime numbers less than a non-negative number, n.
     */
    public int countPrimes(int n) {
        if (n <= 1)
            return 0;
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int num = 2; num < n; num++) {
            if (!notPrime[num]) {
                ++count;
                for (int j = 2; num * j < n; j++)
                    notPrime[num * j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int val =
                new Solution().countPrimes(301);
        System.out.println(val);
    }
}
