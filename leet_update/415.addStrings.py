class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        # ma = {'0':0,'1':'1'}
        ma = {}
        for i in range(10):
            ma.setdefault(str(i), i)
        n1, n2 = 0, 0
        for i in range(len(num1)):
            n1 *= 10
            n1 += ma[num1[i]]
        for i in range(len(num2)):
            n2 *= 10
            n2 += ma[num2[i]]

        return str(n1 + n2)


Solution().addStrings("100", "200")
