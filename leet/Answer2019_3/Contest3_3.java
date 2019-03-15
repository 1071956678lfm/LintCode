package leet.Answer2019_3;

import java.util.*;

public class Contest3_3 {
    private class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> commonChars(String[] A) {
        List<String> ans = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        if (A.length == 0)
            return ans;
        int minLen = Integer.MAX_VALUE;
        String leastStr = "";
        for (String s : A) { //get least
            if (s.length() < minLen) {
                leastStr = s;
                minLen = s.length();
            }
        }
        for (int i = 0; i < leastStr.length(); ++i) {
            char ch = leastStr.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < A.length; ++i) {
            if (A[i].equals(leastStr))
                continue;
            for (char ch : map.keySet()) {
                int count = getCount(A[i], ch);
                if (count < map.get(ch)) { //less than
                    map.replace(ch, count);
                }
            }
        }
        for (char ch : map.keySet()) {
            for (int i = 0; i < map.get(ch); ++i) {
                ans.add(String.valueOf(ch));
            }
        }
        return ans;
    }

    private int getCount(String s, char ch) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ch)
                ++ans;
        }
        return ans;
    }

    /**
     * We are given that the string "abc" is valid.
     * <p>
     * From any valid string V, we may split V into two pieces X and Y such that X + Y
     * (X concatenated with Y) is equal to V.  (X or Y may be empty.)
     * Then, X + "abc" + Y is also valid.
     * <p>
     * If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".
     * Examples of invalid strings are: "abccba", "ab", "cababc", "bac".
     * <p>
     * Return true if and only if the given string S is valid.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: "aabcbc"
     * Output: true
     * Explanation:
     * We start with the valid string "abc".
     * Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".
     * Example 2:
     * <p>
     * Input: "abcabcababcc"
     * Output: true
     * Explanation:
     * "abcabcabc" is valid after consecutive insertings of "abc".
     * Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is "abcabcababcc".
     */
    public boolean isValid(String S) {
        String pattern = "abc";
        if (S == null || S.length() < pattern.length() || S.length() % pattern.length() != 0)
            return false;
        if (S.equals(pattern))
            return true;
        Stack<String> stack = new Stack<>();
        int index = 1;
        stack.push(String.valueOf(S.charAt(0)));
        while (index < S.length()) {
            switch (S.charAt(index)) {
                case 'a':
                    stack.push("a");
                    break;
                case 'b':
                    if (stack.empty())
                        return false;
                    if (stack.peek().equals("a")) {
                        stack.pop();
                        stack.push("b");
                        break;
                    } else {
                        return false;
                    }
                case 'c':
                    if (stack.empty())
                        return false;
                    if (stack.peek().equals("b")) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
            ++index;
        }
        if (!stack.empty())
            return false;
        else
            return true;
    }

    public int longestOnes(int[] A, int K) {
        int curCount = K;
        int ans = 0;
        int cur = 0;
        if (K == 0)
            return count(A);
        for (int begin = 0; begin < A.length; begin++) {
            for (int j = begin; j < A.length; j++) {
                if (A[j] == 1) {
                    cur++;
                } else { // A[j] = 0
                    if (curCount == 0) {
                        break;
                    } else {
                        --curCount;
                        ++cur;
                    }
                }
            }
            ans = Math.max(ans, cur);
            curCount = K;
            cur = 0;
        }
        return ans;
    }


    private int count(int[] nums) {
        int ans = 0;
        int cur = 0;
        boolean isOne = false;
        for (int i = 0; i < nums.length; ++i) {
            if (!isOne) {
                if (nums[i] == 1) {
                    isOne = true;
                    ++cur;
                }
            } else {
                if (nums[i] == 1) {
                    ++cur;
                } else {
                    ans = Math.max(cur, ans);
                    cur = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int K = 2;
        System.out.println(new Contest3_3().longestOnes(nums, K));
    }
}
