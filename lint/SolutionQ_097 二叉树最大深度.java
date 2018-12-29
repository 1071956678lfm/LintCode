package Questions;

public class SolutionQ_097 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.right == null && root.left == null)
            return 1;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
