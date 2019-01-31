package leet.Vacation2019_1;

//443
public class StrCompression {
    /**
     * Given an array of characters, compress it in-place.
     * <p>
     * The length after compression must always be smaller than or equal to the original array.
     * <p>
     * Every element of the array should be a character (not int) of length 1.
     * <p>
     * After you are done modifying the input array in-place, return the new length of the array.
     * <p>
     * <p>
     * Follow up:
     * Could you solve it using only O(1) extra space?
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input:
     * ["a","a","b","b","c","c","c"]
     * <p>
     * Output:
     * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
     * <p>
     * Explanation:
     * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input:
     * ["a"]
     * <p>
     * Output:
     * Return 1, and the first 1 characters of the input array should be: ["a"]
     * <p>
     * Explanation:
     * Nothing is replaced.
     * <p>
     * <p>
     * Example 3:
     * <p>
     * Input:
     * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     * <p>
     * Output:
     * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
     * <p>
     * Explanation:
     * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
     * Notice each digit has it's own entry in the array.
     */
    public int compress(char[] chars) {
        int singleCounter = 0;
        int replaceIndex = 0;
        char ch = chars[0];
        for (int i = 0; i < chars.length; ++i) {
            if (ch != chars[i]) {
                if (singleCounter == 1) {
                    chars[replaceIndex++] = ch;
                } else {
                    char[] replace = getPositionCount(singleCounter);
                    chars[replaceIndex++] = ch;
                    for (char aReplace : replace) {
                        chars[replaceIndex++] = aReplace;
                    }
                }
                ch = chars[i];
                singleCounter = 1;
            } else {
                ++singleCounter;
            }
        }
        //----------------------------------------------------
        if (singleCounter == 1) {
            chars[replaceIndex++] = ch;
        } else {
            char[] replace = getPositionCount(singleCounter);
            chars[replaceIndex++] = ch;
            for (char aReplace : replace) {
                chars[replaceIndex++] = aReplace;
            }
        }
        return replaceIndex;
    }

    private char[] getPositionCount(int val) {
        assert val > 1;
        String s = String.valueOf(val);
        char[] ans = new char[s.length()];
        for (int i = 0; i < s.length(); ++i)
            ans[i] = s.charAt(i);
        return ans;
    }

    public static void main(String[] args) {
        //["a","a","a","a","a","a","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b",
        // "c","c","c","c","c","c","c","c","c","c","c","c","c","c"]
        String s = "aaaaaabbbbbbbbbbbbbbbbbbbbbccccccccccccc";
        System.out.println(new StrCompression().compress(s.toCharArray()));
    }
}
