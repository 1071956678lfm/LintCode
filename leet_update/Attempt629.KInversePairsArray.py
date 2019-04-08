class Solution:
    def kInversePairs(self, n: int, k: int) -> int:
        """
        Given two integers n and k, find how many different arrays consist of numbers from 1 to
        n such that there are exactly k inverse pairs.

        We define an inverse pair as following: For ith and jth element in the array,
        if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.

        Since the answer may be very large, the answer should be modulo 109 + 7.
        :param n:
        :param k:
        :return:
        """
        dp = [[0 for j in range(k + 1)] for i in range(n)]  # n * (k+1)
        module = 1_000_000_007
        # k == 0 , 均为正序排列
        for row in range(n):
            dp[row][0] = 1
        # n == 1 , 且k != 0 , 全部为0
        for j in range(1, k + 1):
            dp[0][j] = 0

        for i in range(1, n):
            for j in range(1, k + 1):
                # i-1 个数, 逆序个数一致 -> i 个数
                dp[i][j] = dp[i - 1][j]
                # i 个数 , 逆序个数为 j-1 -> 增加一个逆序
                
        return dp[-1][-1] % module



Solution().kInversePairs(3, 4)
