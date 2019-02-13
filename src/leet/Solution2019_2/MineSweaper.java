package leet.Solution2019_2;

import java.util.Arrays;

//529
public class MineSweaper {
    private int[][] direction = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {1, 1},
            {1, -1},
            {-1, -1},
            {-1, 1},
    };

    /**
     * Let's play the minesweeper game (Wikipedia, online game)!
     * <p>
     * You are given a 2D char matrix representing the game board.
     * 'M' represents an unrevealed mine,
     * 'E' represents an unrevealed empty square,
     * 'B' represents a revealed blank square that has no adjacent(above, below, left, right, and all 4 diagonals) mines,
     * digit ('1' to '8')represents how many mines are adjacent to this revealed square,
     * 'X' represents a revealed mine.
     * <p>
     * Now given the next click position --- (row and column indices)
     * among all the unrevealed squares ('M' or 'E'),
     * return the board after revealing this position according to the following rules:
     * <p>
     * If a mine ('M') is revealed, then the game is over - change it to 'X'.
     * If an empty square ('E') with no adjacent mines is revealed,
     * then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
     * If an empty square ('E') with at least one adjacent mine is revealed,
     * then change it to a digit ('1' to '8') representing the number of adjacent mines.
     * Return the board when no more squares will be revealed.
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(x, y, board);
        return board;
    }

    private void dfs(int x, int y, char[][] board) {
        if (!isValid(board, new int[]{x, y}))
            return;
        else if (board[x][y] == 'E') {
            int count = 0;
            for (int[] dic : this.direction) {
                int x1 = x + dic[0], y1 = y + dic[1];
                if (isValid(board, new int[]{x1, y1}) &&
                        board[x1][y1] == 'M')
                    ++count;
            }
            if (count == 0) {
                for (int[] dic : this.direction) {
                    int x1 = x + dic[0], y1 = y + dic[1];
                    board[x][y] = 'B';
                    if (isValid(board, new int[]{x1, y1})) {
                        dfs(x1, y1, board);
                    }
                }
            } else {
                board[x][y] = (char) ('0' + count);
            }
        }
    }

    private boolean isValid(char[][] board, int[] click) {
        int row = board.length;
        int col = board[0].length;
        int x = click[0], y = click[1];
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'E'}
//                {'E', 'E', 'E', 'E', 'E'},
//                {'E', 'E', 'M', 'E', 'E'},
//                {'E', 'E', 'E', 'E', 'E'},
//                {'E', 'E', 'E', 'E', 'E'},
        };
        int[] num = {0, 0};
        System.out.println(Arrays.deepToString(new MineSweaper().updateBoard(board, num)));
    }
}
