package leet.Answer2019_3;

//226
public class InvertBT {
    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        } else {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
            return root;
        }
    }
}
