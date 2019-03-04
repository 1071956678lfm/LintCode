package leet.Answer2019_3;

//518
public class CointChange {
    /**
     * You are given coins of different denominations and a total amount of money.
     * Write a function to compute the number of combinations that make up that amount.
     * You may assume that you have infinite number of each kind of coin.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: amount = 5, coins = [1, 2, 5]
     * Output: 4
     * Explanation: there are four ways to make up the amount:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = 1; j < amount + 1; ++j) {
                if (coins[i] <= j) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(new CointChange().change(amount, coins));
    }
}
