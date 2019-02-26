package leet.Solution2019_2;

import java.util.*;

//865
public class SmallestDepth {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
     * <p>
     * A node is deepest if it has the largest depth possible among any node in the entire tree.
     * <p>
     * The subtree of a node is that node, plus the set of all descendants of that node.
     * <p>
     * Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        //返回层次序遍历中最后一个元素的父节点
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return null;
        Map<TreeNode, TreeNode> map = new HashMap<>(); // 子节点映射到父节点
        Map<TreeNode, Integer> mapHeight = new HashMap<>(); //node -> height
        int height = 1;
        queue.add(root);
        queue.add(flank());
        TreeNode tmp = root;
        map.put(root, null);  //父亲
        mapHeight.put(root, 0);
        do {        //层次遍历
            while (!queue.isEmpty() && !isFlank(queue.peek())) {
                tmp = queue.poll();
                if (tmp.left != null) {
                    map.put(tmp.left, tmp);
                    mapHeight.put(tmp.left, height);
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    map.put(tmp.right, tmp);
                    mapHeight.put(tmp.right, height);
                    queue.add(tmp.right);
                }
            }
            if (queue.isEmpty() || queue.size() == 1)
                break;
            else {
                queue.poll();
                queue.add(flank());
                ++height;
            }
        } while (!queue.isEmpty());
        return findAns(tmp, map, mapHeight);
    }

    private TreeNode findAns(TreeNode lastChild, Map<TreeNode, TreeNode> T_T_map, Map<TreeNode, Integer> T_height_map) {
        int maxHeight = T_height_map.get(lastChild);
        Set<TreeNode> lastLayer = new HashSet<>();
        for (TreeNode tmp : T_height_map.keySet()) {
            if (T_height_map.get(tmp) == maxHeight)
                lastLayer.add(tmp);
        }
        List<TreeNode> last = new LinkedList<>(lastLayer);
        int index = 0;
        while (lastLayer.size() > 1) {
            if (index == last.size()) {
                index = 0;
                last = new LinkedList<>(lastLayer);
            }
            TreeNode tmp = last.get(index);
            lastLayer.remove(tmp);
            lastLayer.add(T_T_map.get(tmp));
            ++index;
        }

        TreeNode ans = lastChild;
        for (TreeNode treeNode : lastLayer) {
            ans = treeNode;
        }
        return ans;
    }

    private boolean isFlank(TreeNode root) {
        return root.val == Integer.MAX_VALUE;
    }

    private TreeNode flank() {
        return new TreeNode(Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(13);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(10);
        System.out.println(new SmallestDepth().subtreeWithAllDeepest(root).val);
    }

}
