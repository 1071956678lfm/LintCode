from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        """
        :param nums:
        :return:
        """
        if len(nums) == 1:
            return nums[0]
        nums = sorted(nums)
        cur = nums[0]
        deplete = False
        for i, item in enumerate(nums[1:]):
            if item != cur and not deplete:
                return cur
            elif deplete:
                deplete = False
                cur = item
            else:
                deplete = True
        return cur


print(Solution().singleNumber([1, 2, 2, 4, 1, ]))
