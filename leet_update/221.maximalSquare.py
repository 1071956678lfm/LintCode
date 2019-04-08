class Solution(object):
    def maximalSquare(self, matrix: list) -> int:
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        row = len(matrix)
        col = len(matrix[0])

        dp = [[0 for i in range(col)] for j in range(row)]
        dp[0][0] = matrix[0][0]

        for i in range(1, row):
            dp[i][0] = dp[i - 1][0]
        for i in range(1, col):
            dp[0][i] = dp[0][i - 1]

        for i in range(1, row):
            for j in range(1, col):
                if matrix[i][j] == 0:
                    matrix[i][j] = matrix[i - 1][j - 1]
                else:
                    tmp_len = min(i - 1, j - 1)
                    matrix[i][j] = matrix[i - 1][j - 1]
                    for k in range(tmp_len):

                        pass

        return 1


Solution().maximalSquare([[1, 3], [2, 4]])
