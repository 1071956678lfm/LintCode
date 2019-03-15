package leet.Sum;

/**
 * 543
 */
public class DiameterBinTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     * <p>
     * Example:
     * Given a binary tree
     * 1
     * / \
     * 2  3
     * / \
     * 4  5
     * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     */
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        if(root == null) return diameter;
        getHeight(root);
        return diameter;
    }
    /**
     * @return The height
     * */
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lDepth = getHeight(root.left);
        int rDepth = getHeight(root.right);
        diameter = Math.max(diameter, lDepth+rDepth);
        return Math.max(lDepth, rDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(new DiameterBinTree().diameterOfBinaryTree(root));
    }

}
