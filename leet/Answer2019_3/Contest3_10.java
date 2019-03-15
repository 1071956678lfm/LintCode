package leet.Answer2019_3;

import java.util.Arrays;

public class Contest3_10 {
    /**
     * Given an array A of integers, we must modify the array in the following way:
     * we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.
     * (We may choose the same index i multiple times.)
     * <p>
     * Return the largest possible sum of the array after modifying it in this way.
     */
    public int largestSumAfterKNegations(int[] A, int K) {
        int ans = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length && K > 0; i++) {
            if (A[i] < 0) {
                A[i] = -A[i];
                Arrays.sort(A);
                i = -1;
                --K;
            } else if (A[i] == 0) {
                break;
            } else {
                if (K % 2 == 0) {
                    break;
                } else {
                    A[i] = -A[i];
                    break;
                }
            }
        }
        for (int i = 0; i < A.length; ++i) {
            ans += A[i];
        }

        return ans;

    }

    public int clumsy(int N) {
        int ans = 0;
        boolean add = true;
        int index = N;
        while (index > 3) {
            int val = three(index, index - 1, index - 2);
            index -= 3;
            ans += add ? val : -val;
            add = false;
            if (index != 0) {
                ans += index;
            }
            --index;
        }
        switch (index) {
            case 3:
                ans += add ? 6 : -6;
                break;
            case 2:
                ans += add ? 2 : -2;
                break;
            case 1:
                ans += add ? 1 : -1;
        }
        return ans;

    }

    private int three(int a, int b, int c) {
        return a * b / c;
    }

    public int minDominoRotations(int[] A, int[] B) {
        if (A.length <= 1)
            return 0;
        int t1 = dpForm(A, B, A[0]);
        int t2 = dpForm(B, A, B[0]);
        int ans;
        if (t1 == -1)
            ans = t2;
        else if (t2 == -1)
            ans = t1;
        else
            ans = Math.min(t1, t2);

        t1 = dpForm(A, B, B[0]);
        if (t1 == -1)
            t1 = Integer.MAX_VALUE;
        t2 = dpForm(B, A, A[0]);
        if (t2 == -1)
            t2 = Integer.MAX_VALUE;
        ans = Math.min(Math.min(t1, t2), ans);

        return ans;
    }

    private int dpForm(int[] A, int[] B, int commonVal) {
        int ans = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == commonVal) {
            } else {
                if (B[i] == commonVal)
                    ++ans;
                else
                    return -1;
            }
        }
        return ans;
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] A, int begin, int end) {
        if (begin < 0 || end < 0)
            return null;
        TreeNode root = new TreeNode(A[begin]);
        if (begin == end) {
            return root;
        }
        int lBegin = -1, lEnd = -1, rBegin = -1, rEnd = -1;
        if (A[begin + 1] <= A[begin]) {
            lBegin = begin + 1;
            lEnd = lBegin;
            while (lEnd < A.length && A[lEnd] < A[begin]) {
                ++lEnd;
            }
            --lEnd;
        }
        if (lEnd < end) {
            if (lEnd == -1)
                rBegin = begin + 1;
            else
                rBegin = lEnd + 1;
            rEnd = end;
        }

        root.left = helper(A, lBegin, lEnd);
        root.right = helper(A, rBegin, rEnd);
        return root;
    }

    public static void main(String[] A) {
        TreeNode treeNode = new Contest3_10().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(treeNode.val);
    }
}
