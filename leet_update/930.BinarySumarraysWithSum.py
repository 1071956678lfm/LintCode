from typing import List


class Solution:
    def numSubarraysWithSum(self, A: List[int], S: int) -> int:
        ans, i, j, cur_sum = 0, 0, 0, 0
        cur_sum = A[0]
        while j < len(A):
            if cur_sum == S:
                ans += 1
                j += 1
                cur_sum += A[j] if j < len(A) else 0
            elif cur_sum < S:
                j += 1
                cur_sum += A[j] if j < len(A) else 0
            else:
                i += 1
                cur_sum -= A[i - 1]

        while i < len(A):
            if cur_sum < S:
                break
            if cur_sum == S:
                ans += 1
                i += 1
                cur_sum -= A[i - 1]
        return ans


print(Solution().numSubarraysWithSum([1, 0, 1, 0, 1], 2))
