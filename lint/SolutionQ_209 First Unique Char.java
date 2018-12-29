package Questions;

import java.util.HashMap;
import java.util.Map;

public class SolutionQ_209 {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here

        return challengedWay(str);
    }

    private char normalWay(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < chars.length; index++) {
            char tmpVal = chars[index];
            if (!map.keySet().contains(tmpVal)) {
                map.put(tmpVal, 1);
            } else {
                map.replace(tmpVal, 2);
            }
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) == 1)
                return ch;
        }
        return '0';
    }

    private char challengedWay(String str) {
        if (str.length() == 1)
            return str.charAt(0);
        int flag;
        for (int index = 0; index < str.length(); index++) {
            flag = 0;
            if (index == str.length() - 1)
                return str.charAt(index);
            for (int i = 0; i < str.length(); i++) {
                if (i!=index&&str.charAt(i) == str.charAt(index)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                return str.charAt(index);
        }
        return '0';
    }

    public static void main(String[] args) {
        SolutionQ_209 solutionQ_197 = new SolutionQ_209();
        System.out.println(solutionQ_197.firstUniqChar("aabv"));
    }
}
