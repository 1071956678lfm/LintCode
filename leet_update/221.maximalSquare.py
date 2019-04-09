class Solution(object):
    def maximalSquare(self, matrix: list) -> int:
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix: return 0
        m, n = len(matrix), len(matrix[0])
        area = max(max([int(i) for i in matrix[0]]), max([int(row[0]) for row in matrix]))
        for i in range(1, m):
            for j in range(1, n):
                flag = min(int(matrix[i - 1][j - 1]), int(matrix[i - 1][j]), int(matrix[i][j - 1]))
                matrix[i][j] = flag + 1 if int(matrix[i][j]) == 1 else 0
                area = max(area, matrix[i][j])
        return area ** 2


ans = Solution().maximalSquare([["0", "0"],
                                ["0", "0"]])
print(ans)
