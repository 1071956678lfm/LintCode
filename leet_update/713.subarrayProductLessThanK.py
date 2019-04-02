class Solution:
    def numSubarrayProductLessThanK(self, nums: 'list', k: 'int') -> 'int':
        if k <= 1:
            return 0
        prod = 1
        ans = left = 0
        for right, val in enumerate(nums):
            prod *= val
            while prod >= k:  # exceed
                prod /= nums[left]
                left += 1
            ans += right - left + 1
        return ans


