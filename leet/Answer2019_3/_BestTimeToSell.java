package leet.Answer2019_3;

/**
 * DP
 */
public class _BestTimeToSell {
    /**
     * Q121
     * <p>
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * If you were only permitted to complete at most one transaction
     * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * <p>
     * Note that you cannot sell a stock before you buy one.
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int[] dp = new int[prices.length];
        int tmpMin = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; ++i) {
            tmpMin = Math.min(tmpMin, prices[i]);
            dp[i] = Math.max(prices[i] - tmpMin
                    , i < 1 ? 0 : dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    /**
     * Q122
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
     * (i.e., buy one and sell one share of the stock multiple times).
     * <p>
     * Note: You may not engage in multiple transactions at the same time
     * (i.e., you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     * Example 3:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     * <p>
     * 本质就是找到一段段的最大递增子序列
     */
    public int maxProfit_2(int[] prices) {
        /* Greedy algorithm */
        if (prices.length <= 1)
            return 0;
        int buyPrice = 0;
        boolean isBuy = false;
        int ans = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (isBuy) {
                if (i == prices.length - 1 ||
                        prices[i] > prices[i + 1]) {
                    //we won't sell the commodity in a higher price
                    // just sell it out
                    isBuy = false;
                    ans += prices[i] - buyPrice;
                }
            } else if (i < prices.length - 1
                    && prices[i] < prices[i + 1]) {
                //when we find one commodity that is cheaper ,just buy it
                buyPrice = prices[i];
                isBuy = true;
            }
        }
        return ans;
        /*
        * One simple code
        * int total = 0;
    for (int i=0; i< prices.length-1; i++) {
        if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
    }

    return total;
        *
        * */
    }

    /**
     * Q123
     * <p>
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * <p>
     * Note: You may not engage in multiple transactions at the same time
     * (i.e., you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [3,3,5,0,0,3,1,4]
     * Output: 6
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     * Example 3:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     * <p>
     * <p>
     * dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
     * <p>
     * <p>
     * For k transactions, on i-th day,
     * if we don't trade then the profit is same as previous day dp[k, i-1];
     * and if we bought the share on j-th day where j=[0..i-1], then sell the share
     * on i-th day then the profit is prices[i] - prices[j] + dp[k-1, j-1] .
     * Actually j can be i as well.
     * When j is i, the one more extra item prices[i] - prices[j] + dp[k-1, j] = dp[k-1, i]
     * looks like we just lose one chance of transaction.
     */
    private int maxProfit_3(int[] prices) {
        //transaction at most twice
        int n = prices.length;
        if (n <= 1)
            return 0;
        int[][] dp = new int[3][n];
        for (int i = 0; i < 3; ++i) {
            dp[i] = new int[n];
            for (int j = 0; j < n; ++j) {
                dp[i][j] = 0;
            }
        }

        //1.
        /*
        * for (int k = 1; k <= 2; k++)  {
                for (int i = 1; i < prices.Length; i++) {
                    int min = prices[0];
                    for (int j = 1; j <= i; j++)
                        min = Math.Min(min, prices[j] - dp[k-1, j-1]);
                    dp[k, i] = Math.Max(dp[k, i-1], prices[i] - min);
                }
            }
        * */
        for (int k = 1; k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < n; i++) {
                min = Math.min(min,
                        prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1],   //not trade
                        prices[i] - min);           //sell it out
            }
        }

        return dp[2][n - 1];
    }

    /**
     * Q309
     * <p>
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
     * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
     * <p>
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
     * Example:
     * <p>
     * Input: [1,2,3,0,2]
     * Output: 3
     * Explanation: transactions = [buy, sell, cooldown, buy, sell]
     */
    public int maxProfit_CoolDown(int[] prices) {
        //we have one day cool down
        int ans = 0;
        if (prices.length <= 1)
            return ans;

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new _BestTimeToSell()
                .maxProfit_3(nums));
    }
}
