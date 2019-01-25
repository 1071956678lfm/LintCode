package leet.contest.contest_1_25;


import java.util.Stack;

/**
 * 897
 */
public class IncreOrderST {
    /**
     * Given a tree, rearrange the tree in in-order
     * so that the leftmost node in the tree is now the root of the tree,
     * and every node has no left child and only 1 right child.
     */

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode ptr = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ans = new TreeNode(0);
        TreeNode r = ans;
        do {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            if (!stack.empty()) {
                int val = stack.peek().val;
                ans.right = new TreeNode(val);
                ans = ans.right;
//                tmpPtr = new TreeNode(stack.peek().val);
                ptr = stack.pop();
                ptr = ptr.right;
            }

        } while (ptr != null || !stack.empty());
        return r.right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        new IncreOrderST().increasingBST(treeNode);
    }
}
