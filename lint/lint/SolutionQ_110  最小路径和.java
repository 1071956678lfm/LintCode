package lint;

public class Solution_Q110 {
    public static void main(String[] args) {

    }

    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] DP = new int[row][col];
        DP[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            DP[0][i] = DP[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            DP[i][0] = DP[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                DP[i][j] = Math.min(DP[i - 1][j], DP[i][j - 1]) + grid[i][j];
            }
        }
        return DP[row - 1][col - 1];

    }
}
