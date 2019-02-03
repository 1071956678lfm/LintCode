package leet.Solution2019_2;

//988
public class SmallestStr {
    /**
     * Given the root of a binary tree,
     * each node has a value from 0 to 25 representing the letters 'a' to 'z':
     * a value of 0 represents 'a', a value of 1 represents 'b', and so on.
     * <p>
     * Find the lexicographically smallest string that starts at a leaf of
     * this tree and ends at the root.
     * <p>
     * (As a reminder, any shorter prefix of a string is lexicographically smaller:
     * for example, "ab" is lexicographically smaller than "aba".
     * A leaf of a node is a node that has no children.)
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        return dfs(root);
    }

    private String dfs(TreeNode node) {
        if(node == null) {
            return null;
        }

        char rootValue = (char) ('a' + node.val);
        if(node.left == null && node.right == null) {
            return String.valueOf(rootValue);
        }

        if(node.left != null && node.right != null) {
            String left = dfs(node.left);
            String right = dfs(node.right);

            return (left.compareTo(right) > 0) ? right + rootValue:
                    left + rootValue;
        } else if(node.left != null) {
            String left = dfs(node.left);
            return left + rootValue;
        } else {
            String right = dfs(node.right);
            return right + rootValue;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        System.out.println(new SmallestStr().smallestFromLeaf(root));
    }
}
