package leet.Solution2019_2;

import java.util.Arrays;

//985
public class SumEven {
    /**
     * We have an array A of integers, and an array queries of queries.
     * <p>
     * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].
     * Then, the answer to the i-th query is the sum of the even values of A.
     * <p>
     * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
     * <p>
     * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
     * Output: [8,6,2,4]
     * Explanation:
     * At the beginning, the array is [1,2,3,4].
     * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
     * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
     * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
     * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int tmpSum = 0;
        for (int i = 0; i < A.length; ++i)
            if ((A[i] & 1) == 0)
                tmpSum += A[i];
        for (int index = 0; index < queries.length; ++index) {
            int val = queries[index][0];
            int A_index = queries[index][1];
            int origin = A[A_index];
            if (origin % 2 == 0) {
                if ((origin + val) % 2 != 0)
                    tmpSum -= origin;
                else
                    tmpSum += val;
            } else if (origin % 2 != 0 && (origin + val) % 2 == 0) {
                tmpSum += origin + val;
            }
            A[A_index] += val;
            ans[index] = tmpSum;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] q = {
                {1, 0},
                {-3, 1},
                {-4, 0},
                {2, 3}
        };
        System.out.println(Arrays.toString(new SumEven().sumEvenAfterQueries(A, q)));
    }
}
