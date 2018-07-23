package Questions;

import java.util.Stack;

public class SolutionQ_175 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        invertBinaryTree(left);
        invertBinaryTree(right);
    }

    public void invertTree(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            swap(node);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
    }

    private void swap(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        new SolutionQ_175().invertTree(root);
    }
}