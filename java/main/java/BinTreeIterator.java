import libs.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class BinTreeIterator {

}

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 */
class BSTIterator {
    private static List<Integer> list = new LinkedList<>();
    private static int index = 0;

    public BSTIterator(TreeNode root) {
        init(root);
    }

    private static void init(TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            init(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            init(root.right);
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.get(index++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return index < list.size();
    }

    @Test
    public void run() {

    }
}

