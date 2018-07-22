package Questions;

import java.util.LinkedList;
import java.util.List;

public class SolutionQ_172 {
    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public static int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0)
            return 0;
        List<Integer> originList = new LinkedList<>();
        for (int index = 0; index < A.length; index++) {
            if (A[index] != elem)
                originList.add(A[index]);
        }
        for (int index = 0; index < originList.size(); index++) {
            A[index] = originList.get(index);
        }
        A = new int[originList.size()];
        for (int index = 0; index < originList.size(); index++) {
            A[index] = originList.get(index);
        }
        return A.length;

    }

    private static void change(int[] nums) {
        nums[0] = 100;
    }

    public static void main(String[] args) {
        int[] ints = {0, 4, 4, 0, 4, 4, 4, 0, 2};
        removeElement(ints, 4);
    }


}
