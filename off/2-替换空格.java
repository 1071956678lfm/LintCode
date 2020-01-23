#include"header.h"
/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/

public class Solution {
    private static final String targetStr = "%20";

    public String replaceSpace(StringBuffer str) {
        String tmp = str.toString();
        int n = tmp.length();
        for (int i = 0; i < tmp.length(); ++i) {
            if (tmp.charAt(i) == ' ')
                tmp = replace(tmp, i);
        }
        return tmp;
    }

    public String replace(String target, int idx) {
        String left = target.substring(0, idx),
                right = target.substring(idx + 1);
        return left + targetStr + right;
    }
}