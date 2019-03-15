package leet.Solution2019_2;

import java.util.LinkedList;
import java.util.List;

//784
public class LetterCasePermutation {
    /**
     * Given a string S, we can transform every letter individually to be
     * lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
     * <p>
     * Examples:
     * Input: S = "a1b2"
     * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
     * <p>
     * Input: S = "3z4"
     * Output: ["3z4", "3Z4"]
     * <p>
     * Input: S = "12345"
     * Output: ["12345"]
     */
    private List<String> ans;

    public List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        ans = new LinkedList<>();
        permuteHelper(ans, "", S);

        return ans;
    }

    private void permuteHelper(List<String> list, String sub, String S) {
        if (sub.length() == S.length())
            list.add(sub);
        else {
            int index = sub.length();
            char ch = S.charAt(index);
            if (Character.isDigit(ch)) { //number 0 - 9
                permuteHelper(list, sub + ch, S);
            } else {
                permuteHelper(list, sub+Character.toUpperCase(ch), S);
                permuteHelper(list, sub+Character.toLowerCase(ch), S);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
    }
}
