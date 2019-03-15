package leet.Solution2019_2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Contest_2_26 {

    /**
     * 970
     * Given two non-negative integers x and y,
     * an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
     * <p>
     * Return a list of all powerful integers that have value less than or equal to bound.
     * <p>
     * You may return the answer in any order.  In your answer, each value should occur at most once.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: x = 2, y = 3, bound = 10
     * Output: [2,3,4,5,7,9,10]
     * Explanation:
     * 2 = 2^0 + 3^0
     * 3 = 2^1 + 3^0
     * 4 = 2^0 + 3^1
     * 5 = 2^1 + 3^1
     * 7 = 2^2 + 3^1
     * 9 = 2^3 + 3^0
     * 10 = 2^0 + 3^2
     * Example 2:
     * <p>
     * Input: x = 3, y = 5, bound = 15
     * Output: [2,4,6,8,10,14]
     */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        int[] xNums = getArr(x, bound);
        int[] yNums = getArr(y, bound);
        for (int xNum : xNums) {
            for (int yNum : yNums) {
                int T = xNum + yNum;
                if (T > bound)
                    break;
                ans.add(T);
            }
        }
        return new LinkedList<>(ans);
    }

    private int[] getArr(int x, int bound) {
        if (x == 1)
            return new int[]{1};
        int xB = getSingleBound(x, bound);
        int[] ans = new int[xB + 1];
        ans[0] = 1;
        int t = x;
        for (int i = 1; i < ans.length; ++i) {
            ans[i] = t;
            t *= x;
        }
        return ans;
    }

    private int getSingleBound(int x, int bound) {
        int ans = 1;
        if (x > bound)
            return 0;
        int t = x;
        while (t < bound) {
            t *= x;
            ++ans;
        }
        return ans;
    }

    /**
     * 969
     * Given an array A, we can perform a pancake flip:
     * We choose some positive integer k <= A.length,
     * then reverse the order of the first k elements of A.
     * We want to perform zero or more pancake flips (doing them one after another in succession)
     * to sort the array A.
     * <p>
     * Return the k-values corresponding to a sequence of pancake flips that sort A.
     * Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [3,2,4,1]
     * Output: [4,2,4,3]
     * Explanation:
     * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
     * Starting state: A = [3, 2, 4, 1]
     * After 1st flip (k=4): A = [1, 4, 2, 3]
     * After 2nd flip (k=2): A = [4, 1, 2, 3]
     * After 3rd flip (k=4): A = [3, 2, 1, 4]
     * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
     * Example 2:
     * <p>
     * Input: [1,2,3]
     * Output: []
     * Explanation: The input is already sorted, so there is no need to flip anything.
     * Note that other answers, such as [3, 3], would also be accepted.
     */
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new LinkedList<>();
        /*
         * 1 4 2 3
         * 2-
         * 4 1 2 3
         * 4-j
         * 3 2 1 4
         *
         * 3-j
         * 1 2 3 4
         * */
        for (int size = A.length; size > 0; --size) {
            int maxIndex = findMaxIndex(A, size);
            if (maxIndex == size - 1)
                continue;
            if (maxIndex != 0) {
                ans.add(maxIndex + 1);
                flip(A, maxIndex + 1);
            }
            ans.add(size);
            flip(A, size);
        }

        return ans;
    }

    private void flip(int[] A, int a) {
        for (int i = 0; i < a / 2; ++i) {
            int temp = A[i];
            A[i] = A[a - i - 1];
            A[a - i - 1] = temp;
        }
    }

    private int findMaxIndex(int[] A, int size) {
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            if (A[i] > max)
                max = A[i];
        }
        while (A[ans] != max)
            ++ans;
        return ans;
    }

    /**
     * 971
     * Given a binary tree with N nodes, each node has a different value from {1, ..., N}.
     * <p>
     * A node in this binary tree can be flipped by swapping the left child and the right child of that node.
     * <p>
     * Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.
     * <p>
     * (Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)
     * <p>
     * Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.
     * <p>
     * If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.
     * <p>
     * If we cannot do so, then return the list [-1].
     */
    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return null;
    }

    private TreeNode flipTree(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new Contest_2_26().pancakeSort(new int[]{2, 1, 3}));
    }
}
