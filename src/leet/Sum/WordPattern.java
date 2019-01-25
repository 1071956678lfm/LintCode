package leet.Sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 290
 */
public class WordPattern {
    /**
     * Given a pattern and a string str,
     * find if str follows the same pattern.
     * <p>
     * Here follow means a full match,
     * such that there is a bijection between a letter in pattern and a non-empty word in str.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: pattern = "abba", str = "dog cat cat dog"
     * Output: true
     * Example 2:
     * <p>
     * Input:pattern = "abba", str = "dog cat cat fish"
     * Output: false
     * Example 3:
     * <p>
     * Input: pattern = "aaaa", str = "dog cat cat dog"
     * Output: false
     * Example 4:
     * <p>
     * Input: pattern = "abba", str = "dog dog dog dog"
     * Output: false
     */

    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < pattern.length(); ++i) {
            char ch = pattern.charAt(i);
            String val = arr[i];
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(val))
                    return false;
            } else {
                if (!visited.contains(val)) {
                    map.put(ch, val);
                    visited.add(val);
                } else
                    return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(new WordPattern().wordPattern(pattern, str));
    }
}
