package leet.Solution2019_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//519
public class RandomFlipMatrix {
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(n_rows, n_cols);
     * int[] param_1 = obj.flip();
     * obj.reset();
     */
    class Solution {
        private int[][] grids;
        private int row;
        private int col;

        public Solution(int n_rows, int n_cols) {
            this.grids = new int[n_rows][n_cols];
            this.row = n_rows;
            this.col = n_cols;
            for (int i = 0; i < n_rows; ++i) {
                grids[i] = new int[n_cols];
                for (int j = 0; j < n_cols; ++j) {
                    grids[i][j] = 0;
                }
            }
        }

        /**
         * You are given the number of rows n_rows
         * and number of columns n_cols of a 2D binary matrix where all values are initially 0.
         * Write a function flip which chooses a 0 value uniformly at random, changes it to 1,
         * and then returns the position [row.id, col.id] of that value.
         * Also, write a function reset which sets all values back to 0.
         * Try to minimize the number of calls to system's Math.random() and optimize the time and space complexity.
         * <p>
         * Note:
         * <p>
         * 1 <= n_rows, n_cols <= 10000
         * 0 <= row.id < n_rows and 0 <= col.id < n_cols
         * flip will not be called when the matrix has no 0 values left.
         * the total number of calls to flip and reset will not exceed 1000.
         * Example 1:
         * <p>
         * Input:
         * ["Solution","flip","flip","flip","flip"]
         * [[2,3],[],[],[],[]]
         * Output: [null,[0,1],[1,2],[1,0],[1,1]]
         * Example 2:
         * <p>
         * Input:
         * ["Solution","flip","flip","reset","flip"]
         * [[1,2],[],[],[],[]]
         * Output: [null,[0,0],[0,1],null,[0,0]]
         */
        public int[] flip() {
            int bound = row * col;
            int val = (int) (Math.random() * bound);  //val = i*col + j
            int i, j;

            j = val % col;
            i = (val - j) / col;
            grids[i][j] = 1;
            return new int[]{i, j};
        }

        public void reset() {
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    this.grids[i][j] = 0;
                }
            }
        }
    }

    static class PSolution {
        private Map<Integer, Integer> map;
        private int size;
        private int row;
        private int col;
        private Random rand;

        public PSolution(int n_rows, int n_cols) {
            row = n_rows;
            col = n_cols;
            size = row * col;
            map = new HashMap<>();
            rand = new Random();
        }

        public int[] flip() {
            int r = rand.nextInt(size--);
            int x = map.getOrDefault(r, r);
            map.put(r, map.getOrDefault(size, size));
            return new int[]{x / col, x % col};
        }

        public void reset() {
            map.clear();
            size = row * col;
        }

        public static void main(String[] args) {
            PSolution pSolution = new PSolution(4, 4);

            System.out.println(Arrays.toString(pSolution.flip()));
            System.out.println(Arrays.toString(pSolution.flip()));
            System.out.println(Arrays.toString(pSolution.flip()));
        }
    }
}
