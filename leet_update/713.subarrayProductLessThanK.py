class Solution:
    def numSubarrayProductLessThanK(self, nums: 'List[int]', k: 'int') -> 'int':
        dp = [0] * len(nums)
        if nums[0] < k:
            dp[0] = 1
        for i in range(1, len(dp)):
            if nums[i] >= k:
                dp[i] = dp[i-1]
            else:
                tmp_val = nums[i]
                dp[i] = dp[i-1]
                index = i
                while index >= 0 and tmp_val < k:
                    dp[i] += 1
                    index -= 1
                    tmp_val *= nums[index]
        return dp[-1]


val = Solution().numSubarrayProductLessThanK([10, 5, 2, 6], 100)
print(val)
