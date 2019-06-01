class Solution:
    def validPalindrome(self, s: str) -> bool:
        """
        :param s:
        :return:
        """

        def isP(s):
            for i, item in enumerate(s):
                m = len(s)
                if i >= len(s) // 2:
                    break
                if s[i] != s[-i - 1]:
                    return False
            return True

        if isP(s):
            return True
        else:
            tmp = s
            for i in range(len(s)):
                if isP(tmp):
                    return True
                else:
                    tmp = s
            return False


print(Solution().validPalindrome("abca"))
