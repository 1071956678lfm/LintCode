package leet.Sum;

import java.util.HashSet;
import java.util.Set;

/**
 * 36
 */
public class ValidSudoKu {
    /**
     * Determine if a 9x9 Sudoku board is valid.
     * Only the filled cells need to be validated according to the following rules:
     * <p>
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * <p>
     * A partially filled sudoku which is valid.
     */
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        if (len <= 0)
            return true;
        for (int row = 0; row < 10; ++row) {
            boolean[] rowSet = new boolean[10];
            boolean[] colSet = new boolean[10];
            for (int col = 0; col < 10; ++col) {
                if (board[row][col] != '.') {
                    if (rowSet[board[row][col] - '0'])
                        return false;
                    else rowSet[board[row][col] - '0'] =true;
                }
                if (board[col][row] != '.') {
                    if (colSet[board[col][row] - '0']) {
                        return false;
                    } else
                        colSet[board[col][row] - '0'] = true;
                }
            }
        }
        /*grid area
         * (i,j) (i,j+1) (i,j+2)
         * (i+1,j) (i+1,j+1) (i+1,j+2)
         * (i+2,j) (i+2,j+1) (i+2,j+2)
         *
         * begin index: i,i,i;i+3,i+3,i+3;i+6,i+6,i+6 [j=0,3,6]
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] gridSet = new boolean[10];
                for (int row = i * 3; row < i * 3 + 3; ++row) {
                    for (int col = j * 3; col < j * 3 + 3; ++col) {
                        if (board[row][col] != '.') {
                            int index = board[row][col] - '0';
                            if (gridSet[board[row][col] - '0'])
                                return false;
                            else
                                gridSet[board[row][col] - '0'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
