package leet.Answer2019_3;

import java.util.Arrays;

//977
public class SqureSortArr {
    /**
     * Given an array of integers A sorted in non-decreasing order,
     * return an array of the squares of each number, also in sorted non-decreasing order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Example 2:
     * <p>
     * Input: [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            A[i] = (int) Math.pow(A[i], 2);
        }
        Arrays.sort(A);
        return A;
    }
}
