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
        l = [x for x in range(1, num) if num % x == 0]
        return sum(l) == num
print(Solution().checkPerfectNumber(32))