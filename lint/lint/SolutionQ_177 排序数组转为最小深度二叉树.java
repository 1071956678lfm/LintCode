package lint;

import java.util.Stack;

public class SolutionQ_177 {
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null)
            return null;
        return sortedArrayToBST(A, 0, A.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] A, int left, int right) {
        // write your code here}
        if (A == null || A.length == 0 || left > right)
            return null;
        int center = (left + right) / 2;
        TreeNode root = new TreeNode(A[center]);
        root.left = sortedArrayToBST(A, left, center - 1);
        root.right = sortedArrayToBST(A, center + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1};
        new SolutionQ_177().sortedArrayToBST(nums);
    }
}