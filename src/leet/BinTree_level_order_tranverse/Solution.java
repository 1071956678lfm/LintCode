package leet.BinTree_level_order_tranverse;

import java.util.*;


public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Given a binary tree,
     * return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new LinkedList<>();
        int height = getHeight(root);
        if (height == 0)
            return result;
        for (int i = 0; i < height; i++)
            result.add(new LinkedList<>());
        Map<TreeNode, Integer> map = new HashMap<>(); //[treeNode,height]
        initMap(root, map, 1); //init the map

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int targetHeight = map.get(node);
            result.get(targetHeight - 1).add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return result;
    }

    /**
     * 得到树的深度
     */
    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void initMap(TreeNode root, Map<TreeNode, Integer> map, int currentHeight) {
        if (root == null)
            return;
        map.put(root, currentHeight);
        initMap(root.left, map, currentHeight + 1);
        initMap(root.right, map, currentHeight + 1);
    }

    /**
     * 网上的DFS遍历
     */
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }

    /**
     * 我自己的方法，BFS还可以改进
     * 主要在于，保存size使得每轮循环可以创造一层。
     * 在层次序遍历时不会出现不同层的混乱
     */
    public void BFS_helper(List<List<Integer>> res, TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> item = new LinkedList<>();
            int size = treeNodeQueue.size();
            while (size != 0) {
                TreeNode tmp = treeNodeQueue.poll();
                if (tmp.left != null)
                    treeNodeQueue.add(tmp.left);
                if (tmp.right != null)
                    treeNodeQueue.add(tmp.right);
                item.add(tmp.val);
                --size;
            }
            res.add(item);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        List<List<Integer>> result = new Solution().levelOrder(root);
    }
}
