package lint;

import java.util.Arrays;

public class Solution_Q110 {
    /**
     * @param triangle : a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public static int minimumTotal(int[][] triangle) {
        int row = triangle.length;
        int maxCol = triangle[row - 1].length;
        int[][] DP = new int[row][maxCol];
        DP[0][0] = triangle[0][0];
        for (int rowLine = 1; rowLine < row; rowLine++) {
            DP[rowLine][0] = DP[rowLine - 1][0] + triangle[rowLine][0];
        }
        for (int rowLine = 1; rowLine < row; rowLine++) {
            DP[rowLine][triangle[rowLine].length - 1] = DP[rowLine - 1][triangle[rowLine - 1].length - 1] +
                    triangle[rowLine][triangle[rowLine].length - 1];
        }
        for (int DPRow = 1; DPRow < row; DPRow++) {
            for (int col = 1; col < triangle[DPRow].length - 1; col++) {
                DP[DPRow][col] = Math.min(DP[DPRow - 1][col], DP[DPRow - 1][col - 1]) + triangle[DPRow][col];
            }
        }
        return Arrays.stream(DP[row - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        int[][] ints = {
                {2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3},
        };
        System.out.println(minimumTotal(ints));
    }
}