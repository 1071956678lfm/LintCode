package leet.contest_12_29;

import java.util.Arrays;

public class Assign_cookies {
    /**
     * Assume you are an awesome parent and want to give your children some cookies.
     * But, you should give each child at most one cookie.
     * Each child i has a greed factor gi, which is the minimum size of a cookie
     * that the child will be content with; and each cookie j has a size sj.
     * If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
     * Your goal is to maximize the number of your content children and output the maximum number.
     * <p>
     * Input: [1,2,3], [1,1]
     * <p>
     * Output: 1
     * <p>
     * Explanation: You have 3 children and 2 cookies.
     * The greed factors of 3 children are 1, 2, 3.
     * And even though you have 2 cookies,
     * since their size is both 1, you could only make the child whose greed factor is 1 content.
     * You need to output 1.
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int bound = Math.min(g.length, s.length);//Get the min of the size
        int index_g = 0;
        int index_s = 0;
        for (; index_s < s.length && count < g.length; index_s++) {
            if (g[index_g] <= s[index_s]) {
                index_g++;
                count++;
            }
        }
        return count;
    }

}
