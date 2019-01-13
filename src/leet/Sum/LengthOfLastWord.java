package leet.Sum;

/**
 * 058
 */
public class LengthOfLastWord {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
     * return the length of last word in the string.
     * <p>
     * If the last word does not exist, return 0.
     * <p>
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * <p>
     * Example:
     * <p>
     * Input: "Hello World"
     * Output: 5
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        String[] strings = s.split("[ ]+");
        return
                strings[strings.length - 1].length();
    }

    public static void main(String[] args) {
        int n = new LengthOfLastWord().lengthOfLastWord("hello world ");
        System.out.println(n);

    }
}
