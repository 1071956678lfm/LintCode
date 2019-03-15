package leet.Solution2019_2;

//925
public class LongPressedName {
    /**
     * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c,
     * the key might get long pressed, and the character will be typed 1 or more times.
     * <p>
     * You examine the typed characters of the keyboard.
     * Return True if it is possible that it was your friends name,
     * with some characters (possibly none) being long pressed.
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed))
            return true;
        if (typed.length() < name.length())
            return false;
        int indexName = 0;
        int indexTyped = 0;
        while (indexName < name.length()) {
            if (indexTyped >= typed.length())
                return false;
            int tmpLen = getDepulites(name.charAt(indexName), name.substring(indexName));
            int tmpTypeLen = getDepulites(typed.charAt(indexTyped), typed.substring(indexTyped));
            if (tmpLen > tmpTypeLen) {
                return false;
            } else {
                indexName += tmpLen;
                indexTyped += tmpTypeLen;
            }
        }
        return true;
    }

    private int getDepulites(char ch, String sub) {
        int ans = 0;
        while (ans < sub.length() && sub.charAt(ans) == ch)
            ++ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongPressedName().isLongPressedName("saeed",
                "ssaaedd"));
    }
}
