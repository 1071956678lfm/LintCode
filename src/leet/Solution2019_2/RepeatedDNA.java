package leet.Solution2019_2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//187
public class RepeatedDNA {
    /**
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
     * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
     * <p>
     * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
     * <p>
     * Example:
     * <p>
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * <p>
     * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ans = new HashSet<>();
        System.out.println(s.length());
        for (int i = 0; i + 10 <= s.length(); ++i) {
            if (isRepeated(s, i))
                ans.add(s.substring(i, i + 10));
        }
        return new LinkedList<>(ans);
    }

    /**
     * Use the reg pattern to determine whether the sub[begin,begin+10] is valid
     *
     * @param s     : The whole string
     * @param begin : begin index
     */
    private boolean isRepeated(String s, int begin) {
        String pattern = s.substring(begin, begin + 10);
        String sub = s.substring(begin + 1);

        String[] strings = sub.split(pattern);
        return strings.length == 0 ||
                strings[0].length() < sub.length();
    }

    public static void main(String[] args) {
        String[] strings = "ABCDEF".split("ZZZ");
        System.out.println(new RepeatedDNA().findRepeatedDnaSequences("GAGAGAGAGAGA"));
    }
}
