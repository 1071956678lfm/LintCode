package leet.Sum;

/**
 * 701
 */
public class InsertIntoBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Given the root node of a binary search tree (BST)
     * and a value to be inserted into the tree, insert the value into the BST.
     * Return the root node of the BST after the insertion.
     * It is guaranteed that the new value does not exist in the original BST.
     * <p>
     * Note that there may exist multiple valid ways for the insertion,
     * as long as the tree remains a BST after insertion. You can return any of them.
     * <p>
     * For example,
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val == val)
            return root;
        else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else
            root.right = insertIntoBST(root.right, val);
        return root;
    }
}
