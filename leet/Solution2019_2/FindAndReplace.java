package leet.Solution2019_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//890
public class FindAndReplace {
    /**
     * You have a list of words and a pattern,
     * and you want to know which words in words matches the pattern.
     * <p>
     * A word matches the pattern if there exists a permutation of
     * letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
     * <p>
     * (Recall that a permutation of letters is a bijection from letters to letters:
     * every letter maps to another letter, and no two letters map to the same letter.)
     * <p>
     * Return a list of the words in words that match the given pattern.
     * <p>
     * You may return the answer in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
     * Output: ["mee","aqq"]
     * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
     * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
     * since a and b map to the same letter.
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new LinkedList<>();
        int n = pattern.length();
        for (String s : words) {
            if (s.length() == n && isMatch(s, pattern))
                ans.add(s);
        }
        return ans;
    }

    private boolean isMatch(String s, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = pattern.charAt(i);
            char chS = s.charAt(i);
            if (map.keySet().contains(ch)) {
                if (map.get(ch) != chS)
                    return false;
            } else {
                int index = chS - 'a';
                if (visited[index])
                    return false;
                map.put(ch, chS);
                visited[index] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        System.out.println(new FindAndReplace().findAndReplacePattern(strings, pattern));
    }
}
