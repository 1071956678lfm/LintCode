package Questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionQ_133 {
    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    public List<String> longestWords(String[] dictionary) {
        List<String> list = new LinkedList<>();
        list.add(dictionary[0]);
        int maxLen = dictionary[0].length();
        for (int i = 1; i < dictionary.length; i++) {
            int tmpLen = dictionary[i].length();
            if (tmpLen == maxLen) list.add(dictionary[i]);
            if (tmpLen > maxLen) {
                maxLen = tmpLen;
                list.clear();
                list.add(dictionary[i]);
            }

        }
        return list;
    }

    public static void main(String[] args) {

    }
}