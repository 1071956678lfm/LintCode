package leet.Vacation2019_1;

import java.util.Arrays;

//556
public class NextGreaterElement {
    /**
     * Given a positive 32-bit integer n,
     * you need to find the smallest 32-bit integer
     * which has exactly the same digits existing in the integer n
     * and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.
     * <p>
     * Example 1:
     * <p>
     * Input: 12
     * Output: 21
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: 21
     * Output: -1
     * <p>
     * Analyse: 相当于求得下一个排列数
     * 1232561661 ->
     */
    public int nextGreaterElement(int n) {
        char[] s = String.valueOf(n).toCharArray();  //Get the str representation of the integer
        int size = s.length;
        int i = size - 1;
        for (; i > 0; i--) {
            if (s[i] > s[i - 1])//if we find the pre is smaller
                break;
        }
        if (i == 0)
            return -1;
        int j = size - 1;
        boolean flag = false;
        //we have to find the smallest number s[j] that is larger than s[i-1]
        for (int k = size - 1; k > i - 1; --k) {
            if (s[k] > s[i - 1]) {
                if (!flag) {
                    j = k;
                    flag = true;
                } else if (s[k] < s[j]) {
                    j = k;
                }
            }
        }
        swap(s, i - 1, j);
        Arrays.sort(s, i, size);
        long ans = Long.parseLong(String.valueOf(s));
        if (ans > Integer.MAX_VALUE)
            ans = -1;
        return (int) ans;
    }

    /**
     * swap
     */
    private void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }

    public static void main(String[] args) {
        System.out.println(new NextGreaterElement().nextGreaterElement(12443322));
        //ex 13222344
    }
}
