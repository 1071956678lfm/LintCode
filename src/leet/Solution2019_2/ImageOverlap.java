package leet.Solution2019_2;

//835
public class ImageOverlap {
    /**
     * Two images A and B are given, represented as binary, square matrices of the same size.
     * (A binary matrix has only 0s and 1s as values.)
     * <p>
     * We translate one image however we choose (sliding it left, right, up, or down any number of units),
     * and place it on top of the other image.
     * After, the overlap of this translation is the number of positions that have a 1 in both images.
     * <p>
     * (Note also that a translation does not include any kind of rotation.)
     * <p>
     * What is the largest possible overlap?
     * <p>
     * Input: A = [[1,1,0],
     * [0,1,0],
     * [0,1,0]]
     * B = [[0,0,0],
     * [0,1,1],
     * [0,0,1]]
     * Output: 3
     * Explanation: We slide A to right by 1 unit and down by 1 unit.
     */
    public int largestOverlap(int[][] A, int[][] B) {
        int ans = 0;
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, Math.max(getOverlap(A, B, i, j),
                        getOverlap(B, A, i, j)));
            }
        }
        return ans;
    }

    private int getOverlap(int[][] A, int[][] B, int rowOff, int colOff) {
        int n = A.length;
        int ans = 0;
        for (int i = rowOff; i < n; ++i) {
            for (int j = colOff; j < n; ++j) {
                ans += A[i][j] * B[i - rowOff][j - colOff];
            }
        }
        return ans;
    }
}
