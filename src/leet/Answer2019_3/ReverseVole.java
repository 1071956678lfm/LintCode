package leet.Answer2019_3;

import java.util.LinkedList;

//345
public class ReverseVole {
    /**
     * Write a function that takes a string as input and reverse only the vowels of a string.
     */
    public String reverseVowels(String s) {
        String pattern = "[aeiouAEIOU]";
        if (s.length() == 0)
            return "";
        StringBuilder vowelStr = new StringBuilder();
        LinkedList<Integer> indexList = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            String sub = s.substring(i, i + 1);
            if (sub.matches(pattern)) {
                indexList.add(i);
                vowelStr.append(sub);
            }
        }
        vowelStr.reverse();
        char[] chars = s.toCharArray();
        for (int i = 0; i < indexList.size(); ++i) {
            chars[indexList.get(i)] = vowelStr.charAt(i);
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "aA";
        System.out.println(new ReverseVole().reverseVowels(s));
    }
}
