package leet.Sum;

import javafx.scene.layout.Pane;

/**
 * 073
 */
public class SetMatrixZero {
    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [1,1,1],
     * [1,0,1],
     * [1,1,1]
     * ]
     * Output:
     * [
     * [1,0,1],
     * [0,0,0],
     * [1,0,1]
     * ]
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;
        boolean firstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0)
                firstCol = true;
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int i = 1; i < matrix[0].length; i++)
                    matrix[row][i] = 0;
            }
        }
        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                for (int i = 1; i < matrix.length; i++)
                    matrix[i][col] = 0;
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}
