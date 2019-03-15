package leet.NumMatrix_304;

/**
 * Given a 2D matrix matrix,
 * find the sum of the elements inside the rectangle defined by its upper left corner
 * (row1, col1) and lower right corner (row2, col2).
 * <p>
 * Range Sum Query 2D
 * <p>
 * <p>
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 * <p>
 * <p>
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */
public class NumMatrix {
    /**
     * 一道动态规划的题目
     */
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0)
            return;
        dp = new int[matrix.length][matrix[0].length];
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            dp[rowIndex][0] = matrix[rowIndex][0];
            for (int colIndex = 0; colIndex < matrix[0].length - 1; colIndex++) {
                dp[rowIndex][colIndex + 1] = dp[rowIndex][colIndex] + matrix[rowIndex][colIndex + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1--;
        row2--;
        col1--;
        col2--;
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += (col1 == 0) ? dp[i][col2] : dp[i][col2] - dp[i][col1 - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] martix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        };
        new NumMatrix(martix).sumRegion(2, 2, 3, 3);
    }
}

/**
 * Given an integer array nums,
 * find the sum of the elements between indices i and j (i ≤ j), inclusive.
 */
class NumArry {
    /*
     * Array dp means the sum array of the target array
     *
     * */
    int[] dp;

    /**
     * @param array :Target array
     */
    public NumArry(int[] array) {
        dp = new int[array.length];
        dp[0] = array[0];
        if (array.length <= 1)
            return;
        for (int i = 0; i < array.length - 1; i++) {
            dp[i + 1] = array[i + 1] + dp[i];
        }
    }

    /**
     * The update(i, val) function modifies nums by updating the element at index i to val.
     * <p>
     * we should use segment tree
     *
     * @param i:   index
     * @param val: new value
     */
    public void update(int i, int val) {

    }

    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
    }
}
