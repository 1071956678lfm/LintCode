package leet.Solution2019_2;

import java.util.Arrays;
import java.util.Comparator;

//354
public class Russan {
    /**
     * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
     * One envelope can fit into another if and only if both the width and height of one envelope
     * is greater than the width and height of the other envelope.
     * <p>
     * What is the maximum number of envelopes can you Russian doll? (put one inside other)
     * <p>
     * Note:
     * Rotation is not allowed.
     * <p>
     * Example:
     * <p>
     * Input: [[5,4],[6,4],[6,7],[2,3]]
     * Output: 3
     * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
            return 0;
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = 1;
        }
        int ans = dp[0];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] >= envelopes[j][0]
                        && envelopes[i][1] >= envelopes[j][1]) { //we could put it into the envelope [j]
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}
