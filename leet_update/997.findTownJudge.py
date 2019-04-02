from typing import List


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        nums = [[0 for x in range(N)] for y in range(N)]
        for i, j in trust:
            nums[i - 1][j - 1] = 1
        for index, row in enumerate(nums):
            if 1 not in row:
                for i in range(N):
                    if i != index and 0 == nums[i][index]:
                        return -1
                return index + 1
        return -1


t = Solution().findJudge(2, [[1, 2]])
print(t)
