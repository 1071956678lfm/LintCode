import math as m


class Solution(object):
    def checkPerfectNumber(self, num):
        """
        We define the Perfect Number is 
        a positive integer that is equal to the sum of all its positive divisors except itself.

        Now, given an integer n, write a function that returns 
        true when it is a perfect number and false when it is not.
        :type num: int
        :rtype: bool
        """
        bound = int(num ** 0.5)
        ans = 1
        for x in range(2, bound):
            if num % x == 0:
                ans += x
                if num / x != x:
                    ans += num/x
        return ans == num


print(Solution().checkPerfectNumber(32))
