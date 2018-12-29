package lint;

public class SolutionQ_155 {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int m = minDepth(root.right) + 1;
        int n = minDepth(root.left) + 1;
        m = (m == 1) ? Integer.MAX_VALUE : m;//若右子树为空，那么就让他的高度为一个极大值
        n = (n == 1) ? Integer.MAX_VALUE : n;
        return Math.min(m, n);
    }
}
