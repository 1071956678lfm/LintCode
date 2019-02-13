package leet.Solution2019_2;

//236
public class SecondSalary {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode ans = null;

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * <p>
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
     * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     * <p>
     * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * <p>
     * Example 1:
     * <p>
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     * Example 2:
     * <p>
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5,
     * since a node can be a descendant of itself according to the LCA definition.
     * <p>
     * root - left - right 三者中只要有两个为存在p or q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.ans = null;
        findDescends(root, p, q);
        return ans;
    }

    private boolean findDescends(TreeNode root, TreeNode p, TreeNode q) {
        int left, right, mid;
        if (root == null) {
            return false;
        }
        left = findDescends(root.left, p, q) ? 1 : 0;
        right = findDescends(root.right, p, q) ? 1 : 0;
        mid = (root.val == p.val || root.val == q.val) ? 1 : 0;
        if (left + right + mid >= 2)
            ans = root;
        return (left + right + mid) > 0;
    }


}
