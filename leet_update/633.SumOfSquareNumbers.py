class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        import math
        if c == 0:
            return True
        i = 0
        j = int(math.sqrt(c))
        while i <= j:
            if i ** 2 + j ** 2 == c:
                return True
            elif i ** 2 + j ** 2 > c:
                j -= 1
            else:
                i += 1
        return False


print(Solution().judgeSquareSum(1000))
