package leet.Answer2019_3;

//790
public class DominoTromino {
    /**
     * We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape.
     * These shapes may be rotated.
     * <p>
     * XX  <- domino
     * <p>
     * XX  <- "L" tromino
     * X
     * Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.
     * <p>
     * (In a tiling, every square must be covered by a tile.
     * Two tilings are different if and only if there are two 4-directionally adjacent cells on the board
     * such that exactly one of the tilings has both squares occupied by a tile.)
     * <p>
     * Example:
     * Input: 3
     * Output: 5
     * Explanation:
     * The five different ways are listed below, different letters indicates different tiles:
     * XYZ XXZ XYY XXY XYY
     * XYZ YYZ XZZ XYY XXY
     * <p>
     * L 只能和 L 搭配 ---最小为 2 * 3
     * 2 * 1 ---> 1
     * 2 * 2 ---> 2
     */
    public int numTilings(int N) {
        int modole = 1_000_000_007;
        if (N == 0)
            return 0;
        long[] dp = new long[N <= 2 ? 5 : N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        if (N <= 2)
            return (int) dp[N];
        for (int i = 3; i <= N; ++i) {
            dp[i] = (dp[i - 1] * 2L + dp[i - 3]) % modole;
        }
        return (int) (dp[N] % modole);
    }

    public static void main(String[] args) {
        System.out.println(new DominoTromino().numTilings(4));
    }
}
