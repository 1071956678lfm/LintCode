package leet.contest.contest_2_27;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
     * <p>
     * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
     * <p>
     * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
     * <p>
     * Return true if and only if the nodes corresponding to the values x and y are cousins.
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        if (root.val == x || root.val == y)
            return false;
        return getRootVal(root, x) != getRootVal(root, y) &&
                (getHeight(root, x, 1) == getHeight(root, y, 1));
    }

    private int getHeight(TreeNode root, int x, int current) {
        if (root == null)
            return -1;
        if (root.val == x)
            return current;
        int left = getHeight(root.left, x, current + 1);
        if (left != -1)
            return left;
        int right = getHeight(root.right, x, current + 1);
        if (right != -1)
            return right;
        return -1;
    }

    private int getRootVal(TreeNode root, int val) {
        if (root == null)
            return -1;
        if (root.left != null && root.left.val == val)
            return root.val;
        if (root.right != null && root.right.val == val)
            return root.val;
        int left = getRootVal(root.left, val);
        if (left > 0)
            return left;
        int right = getRootVal(root.right, val);
        if (right > 0)
            return right;
        return -1;
    }

    /**
     * In a given grid, each cell can have one of three values:
     * <p>
     * the value 0 representing an empty cell;
     * the value 1 representing a fresh orange;
     * the value 2 representing a rotten orange.
     * Every minute, any fresh orange that is adjacent (4-directionally)
     * to a rotten orange becomes rotten.
     * <p>
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
     * If this is impossible, return -1 instead.
     */
    private class Ele {
        int x = 0;
        int y = 0;

        Ele(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int R;
    private int C;

    public int orangesRotting(int[][] grid) {
        if (!checkAll(grid))//no fresh
            return 0;
        this.R = grid.length;
        this.C = grid[0].length;
        // Create a queue of cells
        Queue<Ele> Q = new LinkedList<>();
        Ele temp;
        int ans = 0;
        // Store all the cells having rotten orange in first time frame
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (grid[i][j] == 2)
                    Q.add(new Ele(i, j));

        // Separate these rotten oranges from the oranges which will rotten
        // due the oranges in first time frame using delimiter which is (-1, -1)
        Q.add(new Ele(-1, -1));

        // Process the grid while there are rotten oranges in the Queue
        while (!Q.isEmpty()) {
            // This flag is used to determine whether even a single fresh
            // orange gets rotten due to rotten oranges in current time
            // frame so we can increase the count of the required time.
            // So we could ensure that every expansion just increase once.
            boolean flag = false;

            // Process all the rotten oranges in current time frame.
            // Delimiter is the symbol to show every expansion
            while (!isDelim(Q.peek())) {
                temp = Q.peek();

                // Check right adjacent cell that if it can be rotten
                if (isValid(grid, temp.x + 1, temp.y) && grid[temp.x + 1][temp.y] == 1) {
                    if (!flag) {
                        // if this is the first orange to get rotten, increase
                        // count and set the flag.
                        ans++;
                        flag = true;
                    }
                    // Make the orange rotten
                    grid[temp.x + 1][temp.y] = 2;

                    // push the adjacent orange to Queue
                    temp.x++;
                    Q.add(new Ele(temp.x, temp.y));

                    // Move back to current cell
                    temp.x--;
                }

                // Check left adjacent cell that if it can be rotten
                if (isValid(grid, temp.x - 1, temp.y) && grid[temp.x - 1][temp.y] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    grid[temp.x - 1][temp.y] = 2;
                    temp.x--;
                    Q.add(new Ele(temp.x, temp.y)); // push this cell to Queue
                    temp.x++;
                }

                // Check top adjacent cell that if it can be rotten
                if (isValid(grid, temp.x, temp.y + 1) && grid[temp.x][temp.y + 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    grid[temp.x][temp.y + 1] = 2;
                    temp.y++;
                    Q.add(new Ele(temp.x, temp.y)); // Push this cell to Queue
                    temp.y--;
                }

                // Check bottom adjacent cell if it can be rotten
                if (isValid(grid, temp.x, temp.y - 1) && grid[temp.x][temp.y - 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    grid[temp.x][temp.y - 1] = 2;
                    temp.y--;
                    Q.add(new Ele(temp.x, temp.y)); // push this cell to Queue
                }
                Q.remove();

            }
            // Pop the delimiter
            Q.remove();

            // If oranges were rotten in current frame than separate the
            // rotten oranges using delimiter for the next frame for processing.
            if (!Q.isEmpty()) {
                Q.add(new Ele(-1, -1));
            }

            // If Queue was empty than no rotten oranges left to process so exit
        }

        // Return -1 if all arranges could not rot, otherwise -1.s
        return (checkAll(grid)) ? -1 : ans;
    }

    private boolean isDelim(Ele peek) {
        return peek.x == -1 && peek.y == -1;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    private boolean checkAll(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1)
                    return true;
            }
        }
        return false;
    }

    /**
     * In an array A containing only 0s and 1s, a K-bit flip consists of choosing a (contiguous) subarray of
     * length K and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.
     * <p>
     * Return the minimum number of K-bit flips required so that there is no 0 in the array.
     * If it is not possible, return -1.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: A = [0,1,0], K = 1
     * Output: 2
     * Explanation: Flip A[0], then flip A[2].
     * Example 2:
     * <p>
     * Input: A = [1,1,0], K = 2
     * Output: -1
     * Explanation: No matter how we flip subarrays of size 2, we can't make the array become [1,1,1].
     * Example 3:
     * <p>
     * Input: A = [0,0,0,1,0,1,1,0], K = 3
     * Output: 3
     * Explanation:
     * Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
     * Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
     * Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]
     */
    public int minKBitFlips(int[] A, int K) {
        return -1;
    }

    /**
     * Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements,
     * their sum is a perfect square.
     * <p>
     * Return the number of permutations of A that are squareful.
     * Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [1,17,8]
     * Output: 2
     * Explanation:
     * [1,8,17] and [17,8,1] are the valid permutations.
     * Example 2:
     * <p>
     * Input: [2,2,2]
     * Output: 1
     */
    private int ans = 0;

    public int numSquarefulPerms(int[] A) {
        helper(A, new LinkedList<>());
        return ans;
    }

    private void helper(int[] A, List<Integer> list) {
        if (A.length == list.size()) {
            if (check(list)) {
                ans++;
            }
//            list.clear();
        } else {
            for (int i = list.size(); i < A.length; ++i) {
                list.add(A[i]);
                helper(A, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean check(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; ++i) {
            if (!isSqu(list.get(i) + list.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean isSqu(int num) {
        int n = (int) Math.sqrt(num);
        return num == n * n;
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 8};
        System.out.println(new Solution().numSquarefulPerms(nums));
    }
}
