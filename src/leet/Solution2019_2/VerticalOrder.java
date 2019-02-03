package leet.Solution2019_2;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

//987
public class VerticalOrder {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private class Triple implements Comparable<Triple> {
        int x;
        int y;
        int val;

        Triple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Triple o2) {
            if (this.x != o2.x) {
                return this.x - o2.x;
            } else {
                if (this.y != o2.y) {
                    return o2.y - this.y;
                } else {
                    return this.val - o2.val;
                }
            }
        }
    }

    TreeSet<Triple> triples = new TreeSet<>();

    /**
     * Given a binary tree, return the vertical order traversal of its nodes values.
     * <p>
     * For each node at position (X, Y),
     * its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
     * <p>
     * Running a vertical line from X = -infinity to X = +infinity,
     * whenever the vertical line touches some nodes, we report the values of the nodes
     * in order from top to bottom (decreasing Y coordinates).
     * <p>
     * If two nodes have the same position, then the value of the node
     * that is reported first is the value that is smaller.
     * <p>
     * Return an list of non-empty reports in order of X coordinate.
     * Every report will have a list of values of nodes.
     * <p>
     * left-child -> (x-1,y-1)
     * right-child -> (x+1,y-1)
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        helper(root, 0, 0);
        int x = Integer.MIN_VALUE;
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> tmpList = null;
        for (Triple triple : triples) {
            if (tmpList != null)
                if (triple.x != x) {
                    x = triple.x;
                    ans.add(tmpList);
                    tmpList = new LinkedList<>();
                    tmpList.add(triple.val);
                } else {
                    tmpList.add(triple.val);
                }
            else {
                x = triple.x;
                tmpList = new LinkedList<>();
                tmpList.add(triple.val);
            }
        }
        ans.add(tmpList);
        return ans;
    }

    private void helper(TreeNode root, int x, int y) {
        if (root == null) {
        } else if (root.left == null && root.right == null) {
            triples.add(new Triple(x, y, root.val));
        } else {
            if (root.left != null)
                helper(root.left, x - 1, y - 1);
            if (root.right != null)
                helper(root.right, x + 1, y - 1);
            triples.add(new Triple(x, y, root.val));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new VerticalOrder().verticalTraversal(root));
    }
}
