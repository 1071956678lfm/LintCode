package leet.Solution2019_2;

//84
public class _LargestRec {
    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
     * find the area of largest rectangle in the histogram.
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] dp = new int[heights.length];
        dp[0] = heights[0];
        int height = dp[0];//current height
        for (int i = 1; i < heights.length; ++i) {
            int H = heights[i];
            if (H == 0) {
                dp[i] = dp[i - 1];
                height = 0;
            } else if (H >= height) {  //the cur is higher add the height---
                if (dp[i - 1] + height <= H) {//The single rec is larger , update the height
                    dp[i] = H;
                    height = H;
                } else {                //The former is larger, extend the width
                    dp[i] = height + dp[i - 1];
                }
            } else { // H < height , the cur H is lower
                int width = 1;
                for (int j = i - 1; j >= 0; --j) {
                    if (heights[j] >= H) { //the specific has the height bigger than H
                        ++width;
                    }
                }
                dp[i] = Math.max(width * H, dp[i - 1]);
                if (width * H >= dp[i - 1]) {// if the new is taken, update the height
                    height = H;
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] heights = {1, 2, 3, 4, 5};
        System.out.println(new _LargestRec().largestRectangleArea(heights));
    }
}
