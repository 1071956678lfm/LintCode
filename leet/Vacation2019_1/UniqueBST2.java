package leet.Vacation2019_1;

import java.util.LinkedList;
import java.util.List;

/**
 * 95
 */
public class UniqueBST2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Given an integer n,
     * generate all structurally unique BST's (binary search trees) that store values 1 ... n.
     */
    public List<TreeNode> generateTrees(int n) {
        if (0 == n)
            return new LinkedList<>();
        else return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int begin, int end) {
        List<TreeNode> ans = new LinkedList<>();
        if (begin > end) {
            ans.add(null);
            return ans;
        }
        for (int i = begin; i <= end; ++i) {
            List<TreeNode> leftSet = generateTrees(begin, i - 1);
            List<TreeNode> rightSet = generateTrees(i + 1, end);
            for (TreeNode l : leftSet)
                for (TreeNode r : rightSet) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
        }
        return ans;
    }
}
