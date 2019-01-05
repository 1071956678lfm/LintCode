package leet.Sum;

/**
 * 434
 */
public class NumberOfStrings {
    /**
     * Count the number of segments in a string,
     * where a segment is defined to be a contiguous sequence of non-space characters.
     * <p>
     * Please note that the string does not contain any non-printable characters.
     * <p>
     * Example:
     * <p>
     * Input: "Hello, my name is John"
     * Output: 5
     */
    public int countSegments(String s) {
        if (s == null || s.trim().equals(""))
            return 0;
        s = s.trim();
        return s.split("[ ]+").length;
    }
}
