package leet.contest.contest_1_25;

import java.util.Arrays;

/**
 * 899
 */
public class OrdelyQueue {
    /**
     * A string S of lowercase letters is given.
     * Then, we may make any number of moves.
     * <p>
     * In each move, we choose one of the first K letters (starting from the left),
     * remove it, and place it at the end of the string.
     * <p>
     * Return the lexicographically smallest string we could have after any number of moves.
     * <p>
     * Example 1:
     * <p>
     * Input: S = "cba", K = 1
     * Output: "acb"
     * Explanation:
     * In the first move, we move the 1st character ("c") to the end, obtaining the string "bac".
     * In the second move, we move the 1st character ("b") to the end, obtaining the final result "acb".
     * Example 2:
     * <p>
     * Input: S = "baaca", K = 3
     * Output: "aaabc"
     * Explanation:
     * In the first move, we move the 1st character ("b") to the end, obtaining the string "aacab".
     * In the second move, we move the 3rd character ("c") to the end, obtaining the final result "aaabc".
     */
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        } else {
            String result = S;
            int num = S.length();
            S += S; //get the Minimum
            for (int i = 0; i < num; ++i) {
                result = result.compareTo(S.substring(i, num + i)) > 0 ? S.substring(i, num + i) : result;
            }
            return result;
        }
    }
}
