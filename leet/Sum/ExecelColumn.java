package leet.Sum;

/**
 * 171
 */
public class ExecelColumn {
    /**
     * Given a column title as appear in an Excel sheet
     * return its corresponding column number.
     * <p>
     * For example:
     * <p>
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * Example 1:
     * <p>
     * Input: "A"
     * Output: 1
     * Example 2:
     * <p>
     * Input: "AB"
     * Output: 28
     * Example 3:
     * <p>
     * Input: "ZY"
     * Output: 701
     */
    public int titleToNumber(String s) {
        int result = 0;
        int offset = 1 - 'A';
        for (int i = 0; i < s.length(); i++) {
            result *= 26;
            result += s.charAt(i) + offset;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ExecelColumn().titleToNumber("ZY"));
    }
}
