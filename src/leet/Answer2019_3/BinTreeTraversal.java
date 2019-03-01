package leet.Answer2019_3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//107
public class BinTreeTraversal {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
     * (ie, from left to right, level by level from leaf to root).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Stack<List<Integer>> tmpStack = new Stack<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(new TreeNode(Integer.MIN_VALUE));
        do {
            List<Integer> tmpList = new LinkedList<>();
            while (queue.peek().val != Integer.MIN_VALUE) {
                TreeNode tmp = queue.poll();
                tmpList.add(tmp.val);
                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
            }
            tmpStack.push(tmpList);
            queue.poll();
            queue.add(new TreeNode(Integer.MIN_VALUE));
        } while (!queue.isEmpty() && queue.size() != 1);

        while (!tmpStack.empty())
            ans.add(tmpStack.pop());
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        System.out.println(new BinTreeTraversal().levelOrderBottom(root));
    }
}
