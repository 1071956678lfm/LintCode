package lint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionQ_197 {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        if (A == null || A.length == 0) return 0;
        int size = A.length;
        Set<Integer> set = new HashSet<>();
        int remainSize = size - 1;
        if (size == 1)
            return A[0];
        int index = 0;
        long result = 0;
        while (remainSize >= 0) {
            int indexVal = A[index];
            set.add(indexVal);
            int multi = getMulti(set, A, indexVal);
            if (multi == 0 && index == size - 1)
                result++;
            else
                result += multi * getPermutationAmount(remainSize);
            remainSize--;
            index++;
        }
        return result;
    }

    private int getMulti(Set<Integer> set, int[] arr, int pivot) {
        int result = 0;
        for (int index = 0; index < arr.length; index++) {
            int tmpVal = arr[index];
            if (!set.contains(tmpVal) && tmpVal < pivot)
                result++;
        }
        return result;
    }

    private long getPermutationAmount(int size) {
        long result = 1;
        while (size >= 2) {
            result *= size;
            size--;
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionQ_197 solutionQ_197 = new SolutionQ_197();
        System.out.println(solutionQ_197.permutationIndex(new int[]{2, 1, 4, 7}));

    }
}
