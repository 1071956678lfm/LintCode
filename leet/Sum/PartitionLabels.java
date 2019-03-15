package leet.Sum;

import java.util.*;

/**
 * 763
 */
public class PartitionLabels {
    /**
     * A string S of lowercase letters is given.
     * We want to partition this string into as many parts as possible so that each letter
     * appears in at most one part,
     * and return a list of integers representing the [size of these parts].
     * <p>
     * Example 1:
     * Input: S = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     * The partition is "ababcbaca", "defegde", "hijhklij".
     * This is a partition so that each letter appears in at most one part.
     * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
     */
    private List<Integer> partitionLabels(String S) {
        int sum = 0;
        List<Integer> list = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        char[] chars = S.toCharArray();
        for (int i = 0, j = 0; i < chars.length; ++i) {
            if (!visited.contains(chars[i])) {
                visited.add(chars[i]);
                if (j < i) { //new partition
                    list.add(i - sum);
                    sum = i;
                    j = S.lastIndexOf(chars[i]);
                }
                if (j < S.lastIndexOf(chars[i])) { //partition union
                    j = S.lastIndexOf(chars[i]);
                }
            }
        }
        list.add(S.length()-sum);

        return list;
    }

    public static void main(String[] args) {
        new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
    }
}
