package leet.Sum;

import java.util.Arrays;

/**
 * 667
 */
public class BeautifulArrange_2 {
    /**
     * Given two integers n and k, you need to construct a list which contains n different positive integers
     * ranging from 1 to n and obeys the following requirement:
     * Suppose this list is [a1, a2, a3, ... , an],
     * then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
     * <p>
     * If there are multiple answers, print any of them.
     * <p>
     * Example 1:
     * Input: n = 3, k = 1
     * Output: [1, 2, 3]
     * Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3,
     * and the [1, 1] has exactly 1 distinct integer: 1.
     * <p>
     * <p>
     * Example 2:
     * Input: n = 3, k = 2
     * Output: [1, 3, 2]
     * Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3,
     * and the [2, 1] has exactly 2 distinct integers: 1 and 2.
     */
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int low = 1;
        int high = k;
        int l = low;
        int h = high;
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if ((low & 1) == 1) {
                ans[pos++] = l++;
            } else
                ans[pos++] = h--;
            if (low < high)
                low++;
            else
                break;
        }
        while (pos < n)
            ans[pos++] = l++;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BeautifulArrange_2().constructArray(3, 2)));
    }
}
