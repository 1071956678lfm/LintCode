class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        Given a string, find the length of the longest substring without repeating characters.

        Example 1:

        Input: "abcabcbb"
        Output: 3 
        Explanation: The answer is "abc", with the length of 3. 
        Example 2:

        Input: "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
        Example 3:

        Input: "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3. 
                    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
        :type s: str
        :rtype: int
        """
        index = 0
        ans = 0
        tmp_arr = ''
        while index < len(s):
            ch = s[index]
            contained, next_index = contain(tmp_arr, ch)
            if contained:  # contain the target char
                ans = max(ans, len(tmp_arr))
                index -= len(tmp_arr) - next_index-1
                tmp_arr = ''
            else:
                tmp_arr += ch
                index += 1
        return max(ans, len(tmp_arr))


def contain(s, ch):
    for i in range(len(s)):
        if s[i] == ch:
            return True, i
    return False, -1


print(Solution().lengthOfLongestSubstring('pwwkew'))
