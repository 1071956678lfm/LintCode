package lint;

public class Solution_Q115 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] DP = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] != 0) continue;
                if (i == 0 && j == 0) DP[i][j] = 1;
                else if (i == 0) DP[i][j] = DP[i][j - 1];
                else if (j == 0) DP[i][j] = DP[i - 1][j];
                else {
                    DP[i][j] = DP[i - 1][j] + DP[i][j - 1];
                }
            }
        }
        return DP[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0}
                , {0, 1, 0}, {0, 0, 0}};

        System.out.println(uniquePathsWithObstacles(arr));
    }
}