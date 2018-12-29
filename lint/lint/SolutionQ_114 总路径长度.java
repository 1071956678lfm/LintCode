package lint;

public class Solution_Q114 {
    /**
     * @param m : positive integer (1 <= m <= 100)
     * @param n : positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public static int uniquePaths(int m, int n) {
        int[][] DP = new int[m][n];
        for (int i = 0; i < m; i++) DP[i][0] = 1;
        for (int i = 0; i < n; i++) DP[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                DP[i][j] = DP[i][j - 1] + DP[i - 1][j];
        }
        return DP[m-1][n-1];

    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(8, 68));
    }
}