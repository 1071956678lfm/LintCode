package leet.Solution2019_2;

import java.util.*;

//139
public class WordBreak {

    /**
     * DP
     * <p>
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     * <p>
     * Note:
     * <p>
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     * <p>
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     * <p>
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     * Note that you are allowed to reuse a dictionary word.
     * Example 3:
     * <p>
     * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output: false
     */
    public boolean wordBreak(String s, List<String> wordDict) {
//        wordDict.sort(Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        dp[0] = set.contains(s.substring(0, 1));
        for (int i = 1; i < dp.length; ++i) {
            char ch = s.charAt(i);
            if (set.contains(String.valueOf(ch)) && dp[i - 1]) {//single char
                dp[i] = true;
            } else {
                for (int j = i - 1; j >= 0; --j) {
                    String sub = s.substring(j, i + 1);
                    if (set.contains(sub) && (j == 0 || dp[j - 1]))
                        dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(new WordBreak().wordBreak("catsandog", list));
    }
}
