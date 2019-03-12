package leet.Answer2019_3;

//10
public class _RegularExpMatch {
    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     * <p>
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     */
    public boolean isMatch(String s, String p) {
        int indexS = 0;
        int indexP = 0;
        p = justify(p);
        while (indexS < s.length() && indexP < p.length()) {
            char sCh = s.charAt(indexS);
            char pCh = p.charAt(indexP);
            if (sCh == pCh || pCh == '.') { // 'a' = 'b'
                ++indexP;
                ++indexS;
                if (indexP == p.length() || indexS == s.length())
                    break;
                else {
                    if (p.charAt(indexP) != '*') {
                    } else {
                        while (indexS < s.length() && (s.charAt(indexS) == sCh || pCh == '.')) {
                            ++indexS;
                        }
                        ++indexP;
                    }
                }
            } else { // 'a' != 'b'
                ++indexP;
                if (indexP < p.length() && p.charAt(indexP) == '*') { // discard.  * means 0
                    ++indexP;
                    if (indexP < p.length() && p.charAt(indexP) == sCh) {
                        ++indexS;
                    }
                } else {
                    return false;
                }
            }
        }
        return indexS >= s.length() && (indexP >= s.length() || isNull(p.substring(indexP)));
    }

    private String justify(String p) {
        if (p.length() == 0)
            return p;
        StringBuilder ans = new StringBuilder();
        char before = p.charAt(0);
        ans.append(before);
        int index = 1;
        while (index < p.length()) {
            char ch = p.charAt(index);
            if (ch != '*') {
                if (ch != before) {
                    before = ch;
                    ans.append(before);
                } else if (ans.charAt(ans.length() - 1) != '*') {
                    ans.append(before);
                }
            } else {
                ans.append('*');
            }
            ++index;
        }
        return ans.toString();
    }

    private boolean isNull(String p) {
        if (p.split("[\\w][*]").length == 0 || p.equals(""))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(new _RegularExpMatch().isNull(""));
        System.out.println(new _RegularExpMatch().isMatch("aaa", "a*b*a*c*a"));
    }
}
