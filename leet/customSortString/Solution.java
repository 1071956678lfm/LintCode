package leet.customSortString;

import java.util.*;

/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 * <p>
 * S was sorted in some custom order previously.
 * We want to permute the characters of T so that they match the order that S was sorted.
 * More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 * <p>
 * Return any permutation of T (as a string) that satisfies this property.
 * <p>
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T.
 * "dcba", "cdba", "cbda" are also valid outputs.
 */
public class Solution {

    public String customSortString(String S, String T) {
        return solutionB(S, T);
    }

    private String solutionB(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T.length(); i++)
            map.put(T.charAt(i),
                    map.getOrDefault(T.charAt(i), 0) + 1);
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < map.getOrDefault(S.charAt(i),0); j++)
                result.append(S.charAt(i));
            map.put(S.charAt(i), 0);
        }
        for (char c : map.keySet()) {
            for (int i = 0; i < map.getOrDefault(c, 0); ++i)
                result.append(c);
        }
        return result.toString();
    }

    private String solutionA(String S, String T) {
        Map<Character, Integer> map = new HashMap<>(); //from char to the index
        for (int i = 0; i < S.length(); ++i)
            map.put(S.charAt(i), i);
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < T.length(); i++)
            list.add(T.charAt(i));
        list.sort((o1, o2) -> {
            int index1 = map.getOrDefault(o1, -1);
            int index2 = map.getOrDefault(o2, -1);
            return index1 - index2;
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T.length(); i++)
            stringBuilder.append(list.get(i));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().customSortString("abc", "bcad");
    }
}
