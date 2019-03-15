package leet.Solution2019_2;

/**
 * 745
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
public class PPSearch {
    private static String[] words = {
            "abbbababbb", "baaabbabbb", "abababbaaa", "abbbbbbbba", "bbbaabbbaa", "ababbaabaa",
            "baaaaabbbb", "babbabbabb", "ababaababb", "bbabbababa"
    };
    private static String prefix = "";
    private static String suffix = "abaa";

    /**
     * Given many words, words[i] has weight i.
     * <p>
     * Design a class WordFilter that supports one function,
     * WordFilter.f(String prefix, String suffix).
     * It will return the word with given prefix and suffix with maximum weight.
     * If no word exists, return -1.
     * <p>
     * Examples:
     * Input:
     * WordFilter(["apple"])
     * WordFilter.f("a", "e") // returns 0
     * WordFilter.f("b", "") // returns -1
     * <p>
     * ["WordFilter","f","f","f","f","f","f","f","f","f","f"]
     * [[["abbbababbb","baaabbabbb","abababbaaa","abbbbbbbba","bbbaabbbaa","ababbaabaa",
     * "baaaaabbbb","babbabbabb","ababaababb","bbabbababa"]],
     * ["","abaa"],["babbab",""],["ab","baaa"],
     * ["baaabba","b"],["abab","abbaabaa"],["","aa"],["","bba"],["","baaaaabbbb"],["ba","aabbbb"],["baaa","aabbabbb"]]
     */
    static class WordFilter {

        private String[] words;

        public WordFilter(String[] words) {
            this.words = words;
        }

        public int f(String prefix, String suffix) {
            int ans = -1;
            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                if (word.startsWith(prefix) &&
                        word.endsWith(suffix)) {
                    ans = i;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(words);
        int n = wordFilter.f(prefix, suffix);
        System.out.println(n);
    }
}
