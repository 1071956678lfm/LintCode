package leet.Vacation2019_1;

//777
public class SwapAdjacent {
    /**
     * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
     * a move consists of either replacing one occurrence of "XL" with "LX",
     * or replacing one occurrence of "RX" with "XR".
     * Given the starting string start and the ending string end,
     * return True if and only if there exists a sequence of moves to transform one string to the other.
     * <p>
     * Example:
     * <p>
     * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
     * Output: True
     * Explanation:
     * We can transform start to end following these steps:
     * RXXLRXRXL ->
     * XRXLRXRXL ->
     * XRLXRXRXL ->
     * XRLXXRRXL ->
     * XRLXXRRLX
     */
    public boolean canTransform(String start, String end) {
        int l = 0, r = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) == 'R')
                ++r;
            if (end.charAt(i) == 'R')
                --r;
            if (end.charAt(i) == 'L')
                ++l;
            if (start.charAt(i) == 'L')
                --l;
            if (l < 0 || r < 0 || l * r != 0)
                return false;
        }
        return l == 0 && r == 0;
    }
}
