package Questions;

public class SolutionQ_185 {
    /**
     * @param matrix: An array of integers
     * @return: An array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
//        resultArr[index++] = matrix[0][0];
//        if (col == 1) {
//            for (; index < row; index++)
//                resultArr[index] = matrix[index][0];
//            return resultArr;
//        }
//
//
//        int i = 1, j = 2;
////        while (i + j <= row + col && index < size) {
////            if (i == 1) {
////                for (; i <= row && j >= 1; i++, j--) {
////                    resultArr[index++] = matrix[i - 1][j - 1];
////                }
////                if (i == row)
////                    j++;
////                else if (i > row) {
////                    j += 2;
////                    i--;
////                } else if (j == 1) {
////                    i++;
////                }
////            } else if (j == 1) {
////                for (; j <= col && i >= 1; i--, j++) {
////                    resultArr[index++] = matrix[i - 1][j - 1];
////                }
////                if (j == col)
////                    i++;
////                else if (j > col) {
////                    i += 2;
////                    j--;
////                } else if (i == 1) {
////                    j++;
////                }
////            } else if (i == row) {
////                for (; j <= col && i >= 1; j++, i--) {
////                    resultArr[index++] = matrix[i - 1][j - 1];
////                }
////
////                i += 2;
////                j--;
////            } else if (j == col) {
////                for (; i <= row && j >= 1; i++, j--) {
////                    resultArr[index++] = matrix[i - 1][j - 1];
////                }
////                j += 2;
////                i--;
////            }
////        }
//        while (index < size) {
//
//        }
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;
        int row = matrix.length;
        int col = matrix[0].length;
        int size = row * col;
        int[] resultArr = new int[size];
        int lineIndex = row + col - 2;
        for (int n = 0, i = 0, j = 0, index = 0; n <= lineIndex; n++) {
            if (n % 2 == 0) {
                while (i > 0 && j < col - 1)
                    resultArr[index++] = matrix[i--][j++];
                if (j == col - 1)
                    resultArr[index++] = matrix[i++][j];
                else if (i == 0)
                    resultArr[index++] = matrix[i][j++];
            } else {
                while (j > 0 && i < row - 1)
                    resultArr[index++] = matrix[i++][j--];
                if (i == row - 1)
                    resultArr[index++] = matrix[i][j++];
                else if (j == 0)
                    resultArr[index++] = matrix[i++][j];
            }
        }

        return resultArr;
    }

    public static void main(String[] args) {
        int[][] mar = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {9},
                {8},
                {7},
        };
        new SolutionQ_185().printZMatrix(mar);
    }
}