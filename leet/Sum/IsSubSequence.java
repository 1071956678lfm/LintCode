package leet.Sum;

import java.io.*;

/**
 * 392
 */
public class IsSubSequence {
    /**
     * Given a string s and a string t, check if s is subsequence of t.
     * <p>
     * You may assume that there is only lower case English letters in both s and t.
     * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
     * <p>
     * A subsequence of a string is a new string which is formed from the original string
     * by deleting some (can be none) of the characters without disturbing the relative positions
     * of the remaining characters.
     * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
     * <p>
     * Example 1:
     * s = "abc", t = "ahbgdc"
     * <p>
     * Return true.
     * <p>
     * Example 2:
     * s = "axc", t = "ahbgdc"
     * <p>
     * Return false.
     */
    public boolean isSubsequence(String s, String t) {
        int indexS = 0;
        long indexT = 0;
        if (s.length() == 0)
            return true;
        while (indexT < t.length()) {
            try {
                if (s.charAt(indexS) == t.charAt(Math.toIntExact(indexT))) {
                    char chS = s.charAt(indexS);
                    char chT = t.charAt(Math.toIntExact(indexT));
                    ++indexS;
                    ++indexT;
                } else
                    ++indexT;
            } catch (IndexOutOfBoundsException e) {
                return indexS == s.length();
            }
        }
        return indexS == s.length();
    }

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\JAVA文件\\lintCode\\LintCode\\src\\leet\\Sum\\test.txt"));
            String s = bufferedReader.readLine();
            String t = bufferedReader.readLine();
            boolean c = new IsSubSequence().isSubsequence(s, t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
