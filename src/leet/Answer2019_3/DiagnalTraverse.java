package leet.Answer2019_3;

//498
public class DiagnalTraverse {
    /**
     * Given a matrix of M x N elements (M rows, N columns),
     * return all elements of the matrix in diagonal order as shown in the below image.
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int rowCount = matrix.length;
        if (rowCount == 0)
            return new int[0];
        int colCount = matrix[0].length;
        int[] ans = new int[rowCount * colCount];
        int rIndex = 0;
        int cIndex = 0;
        boolean upwards = true;
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = matrix[rIndex][cIndex];
            // left board - rIndex = k,cIndex = 0;

            // up board - rIndex = 0 , cIndex = k;

            //bottom board - rIndex = rowCount , cIndex = k;

            //right board - rIndex =k , cIndex = colCount;
            if (upwards) {
                upwards = false;
                if (rIndex == 0) {//up side
                    ++cIndex;
                    if (cIndex == colCount) { //diagonal
                        --cIndex;
                        ++rIndex;
                    }
                } else if (cIndex == colCount - 1) {//right side
                    ++rIndex;
                    if (rIndex == rowCount)
                        break;
                } else {
                    upwards = true;
                    ++cIndex;
                    --rIndex;
                }
            } else { //down wards
                upwards = true;
                if (rIndex == rowCount - 1) {// bottom side
                    ++cIndex;
                    if (cIndex == colCount)
                        break;
                } else if (cIndex == 0) { //left side
                    ++rIndex;
                    if (rIndex == rowCount) { //diagonal
                        --rIndex;
                        ++colCount;
                    }
                } else {
                    upwards = false;
                    ++rIndex;
                    --cIndex;
                }
            }
        }
        return ans;
    }
}
