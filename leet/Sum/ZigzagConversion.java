package leet.Sum;

import java.util.Arrays;

/**
 * 006
 */
public class ZigzagConversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * Example 1:
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */
    public String convert(String s, int numRows) {
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        if(numRows==1)return s;
        for (int i = 0; i < numRows; i++)
            stringBuilders[i] = new StringBuilder();
        boolean vert = false;
        for (int i = 0, j = 0; i < s.length(); i++) {
            stringBuilders[j].append(s.charAt(i));
            if (vert) {
                if (j == 0) {
                    vert = false;
                    ++j;
                } else
                    --j;
            } else {
                if (j == numRows - 1) {
                    vert = true;
                    --j;
                } else
                    ++j;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder tmp : stringBuilders)
            result.append(tmp.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("AB", 1));
    }
}
