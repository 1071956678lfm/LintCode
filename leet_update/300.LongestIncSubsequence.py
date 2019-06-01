from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        elif len(nums) == 1:
            return 1
        ans, tmp_num = 0, nums[0]
        length = 0
        for index, item in enumerate(nums[1:]):
            if item <= tmp_num:
                ans = max(length, ans)
                tmp_num = item
                length = 0
            else:
                tmp_num = item
                length += 1
        return max(length, ans)


nums = [10, 9, 2, 5, 3, 7, 101, 18]
s = Solution()
print(s.lengthOfLIS(nums))
