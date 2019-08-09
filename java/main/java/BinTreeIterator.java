package main.java;

import libs.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
        dfs(root);
        System.out.println(list);
    }

    private static void dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return;
        TreeNode ptr = root;
        do {
            if (ptr!=null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            while (null != ptr) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            //add to the pre order list
            if (!stack.isEmpty()) {
                ptr = stack.pop();
                list.add(ptr.val);
            } else
                break;
            ptr = ptr.right;
        } while (null != ptr || !stack.isEmpty());
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);
        BSTIterator it = new BSTIterator(root);
        System.out.println(it.hasNext());
    }
}

