package leet.Vacation2019_1;

//696
public class CountBinarySubString {
    /**
     * Give a string s, count the number of non-empty (contiguous)
     * substrings that have the same number of 0's and 1's, and all the 0's
     * and all the 1's in these substrings are grouped consecutively.
     * <p>
     * Substrings that occur multiple times are counted the number of times they occur.
     * <p>
     * Example 1:
     * Input: "00110011"
     * Output: 6
     * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's:
     * "0011", "01", "1100", "10", "0011", and "01".
     * <p>
     * Notice that some of these substrings repeat and are counted the number of times they occur.
     * <p>
     * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
     * Example 2:
     * Input: "10101"
     * Output: 4
     * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
     * <p>
     * <p>
     * 000111 ->  0011 . 01 total = 3
     * 0011 -> 01 total = 2
     * 01 -> total -> 1
     */
    public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }

    public static void main(String[] args) {
        System.out.println(new CountBinarySubString().countBinarySubstrings("00110"));
    }
}
