package Questions;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionQ_007 {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null)
            return "{#}";
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.push(root);
        StringBuilder stringBuilder = new StringBuilder("{");
        int size = 1;
        int height = getHeight(root);
        while (size < Math.pow(2, height)) {
            if (treeNodes.size() == size) {
                size = size << 1;
                while (treeNodes.size() < size) {
                    TreeNode node = treeNodes.removeLast();
                    if (node == null) {
                        stringBuilder.append("#,");
                        treeNodes.push(null);
                        treeNodes.push(null);
                    } else {
                        stringBuilder.append(Integer.toString(node.val) + ',');
                        treeNodes.push(node.left);
                        treeNodes.push(node.right);
                    }
                }

            }
        }
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "}");
        return stringBuilder.toString();
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{#}"))
            return null;
        String[] strings = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        int index = 1;
        root.left = deserialize(strings, root, index, true);
        root.right = deserialize(strings, root, index, false);
        return root;
    }

    private TreeNode deserialize(String[] strings, TreeNode root, int index, boolean b) {
        TreeNode tmpNode;
        int tmpIndex = b ? (index * 2) : (index * 2 + 1);
        if (tmpIndex > strings.length || strings[tmpIndex-1].equals("#")) {
            return null;
        }
        else {
            tmpNode = new TreeNode(Integer.parseInt(strings[tmpIndex-1]));
            tmpNode.left = deserialize(strings, tmpNode, tmpIndex, true);
            tmpNode.right = deserialize(strings, tmpNode, tmpIndex, false);
        }
        if(b)
            root.left=tmpNode;
        else
            root.right=tmpNode;
        return tmpNode;
    }

    public static void main(String[] args) {
        SolutionQ_007 solutionQ_007 = new SolutionQ_007();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        TreeNode tmp = root.right;
        tmp.left = new TreeNode(15);
        tmp.right = new TreeNode(7);

        System.out.println(solutionQ_007.deserialize("{1,2,3,#,#,4,5}"));
    }
}
