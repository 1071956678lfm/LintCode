package lint;

public class SolutionQ_157 {
    /*
     * @param str: A string
     * @return: a boolean
     */
    public static boolean isUnique(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        int len = str.length();
        int index = 0;
        while (len > 0) {
            stringBuilder.replace(0, 1, "");
            if (new String(stringBuilder).contains(str.subSequence(index, index + 1)))
                return false;
            len = stringBuilder.length();
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("acdb"));
    }
}
