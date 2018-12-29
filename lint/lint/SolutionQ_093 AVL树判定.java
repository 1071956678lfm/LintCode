package lint;

public class SolutionQ_093 {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftHeight = getHeight(left);
        int rightHeight = getHeight(right);
        if (leftHeight <= 1 && rightHeight <= 1)
            return true;
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(left) && isBalanced(right);
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
    }
}
