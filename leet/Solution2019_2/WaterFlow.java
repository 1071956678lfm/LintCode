package leet.Solution2019_2;

import java.util.LinkedList;
import java.util.List;

//417
public class WaterFlow {
    /**
     * Given an m x n matrix of non-negative integers
     * representing the depth of each unit cell in a continent,
     * the "Pacific ocean" touches the left and top edges of the matrix
     * and the "Atlantic ocean" touches the right and bottom edges.
     * <p>
     * Water can only flow in four directions (up, down, left, or right)
     * from a cell to another one with depth equal or lower.
     * <p>
     * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
     * <p>
     * Example:
     * <p>
     * Given the following 5x5 matrix:
     * <p>
     * Pacific ~   ~   ~   ~   ~
     * ~  1   2   2   3  (5) *
     * ~  3   2   3  (4) (4) *
     * ~  2   4  (5)  3   1  *
     * ~ (6) (7)  1   4   5  *
     * ~ (5)  1   1   2   4  *
     * *   *   *   * Atlantic
     * <p>
     * Return:
     * <p>
     * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
     */
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new LinkedList<>();
        int n = matrix.length;
        if (n == 0)
            return ans;
        int m = matrix[0].length;
        if (m == 0)
            return ans;
        boolean[][] PV = new boolean[n][m];
        boolean[][] AV = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            flow(PV, matrix, i, 0, n, m);
            flow(AV, matrix, i, m - 1, n, m);
        }
        for (int i = 0; i < m; i++) {
            flow(PV, matrix, 0, i, n, m);
            flow(AV, matrix, n - 1, i, n, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (PV[i][j] && AV[i][j])
                    ans.add(new int[]{i, j});
            }
        }
        return ans;
    }

    private void flow(boolean visited[][], int matrix[][], int x, int y, int n, int m) {
        int dx[] = {0, 0, -1, 1};
        int dy[] = {1, -1, 0, 0};
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                //一个节点是只能留到不高于自己高度的节点，但是我们这里是反过来找能从nxny留到xy的节点，所以这里注意下
                if (!visited[nx][ny] && matrix[nx][ny] >= matrix[x][y])
                    flow(visited, matrix, nx, ny, n, m);
            }
        }
    }
}
