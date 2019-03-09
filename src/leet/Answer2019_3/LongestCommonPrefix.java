package leet.Answer2019_3;

//14
public class LongestCommonPrefix {
    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     * <p>
     * Example 1:
     * <p>
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     * <p>
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();
        String minStr = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                minStr = strs[i];
            }
        }
        int index = 0;
        for (; index < minLen; ++index) {
            String sub = minStr.substring(0, index + 1);
            for (int i = 0; i < strs.length; ++i) {
                String string = strs[i];
                if (!string.startsWith(sub)) {
                    return minStr.substring(0, index);
                }
            }
        }
        return minStr.substring(0, index);
    }
}
