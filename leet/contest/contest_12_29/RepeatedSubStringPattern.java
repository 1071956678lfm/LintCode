package leet.contest.contest_12_29;

import java.util.LinkedList;
import java.util.List;

public class RepeatedSubStringPattern {
    /**
     * Given a non-empty string check if it can be constructed by taking a substring of it
     * and appending multiple copies of the substring together.
     * You may assume the given string consists of lowercase English letters only
     * and its length will not exceed 10000.
     * <p>
     * Input: "abab"
     * <p>
     * Output: True
     * Explanation: It's the substring "ab" twice.
     */
    private boolean repeatedSubstringPattern(String s) {
        List<Integer> factors = getPrimeFactor(s.length());
        for (int size : factors) {
            String sub = s.substring(0, size);
            if (s.split(sub).length == 0)
                return true;
        }
        return false;
    }


    private List<Integer> getPrimeFactor(int val) {
        if (val <= 0)
            return null;
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < val; i++) {
            if (val % i == 0)
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubStringPattern().repeatedSubstringPattern("abacababacab"));
    }

}
