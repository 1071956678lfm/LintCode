package leet.Vacation2019_1;

//32
public class LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.
     * <p>
     * Example 1:
     * <p>
     * Input: "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()"
     * Example 2:
     * <p>
     * Input: ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()"
     */
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); ++i)
            dp[i] = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = ((i >= 2) ? dp[i - 2] : 0) + 2;
                } else {    // ) )  so we should determine whether the  (( ... )) case
                    if (i - dp[i - 1] > 0
                            && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] +
                                ((i - dp[i - 1]) >= 2 ?
                                        dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
            }
            if (dp[i] > ans)
                ans = dp[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()()"));
    }
}
