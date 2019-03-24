class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        upward = True
        ans = 0
        tmp_val = nums[0]
        for i in range(1, len(nums)):
            if nums[i] > tmp_val:
                upward = True
                tmp_val = nums[i]
                ans = i
            elif nums[i] == tmp_val:
                ans = -1
                upward = False
            elif upward:  # upward and tmp_val > nums[i]
                return ans
            else:
                ans = -1
                tmp_val = nums[i]
        return ans


print(Solution().findPeakElement([2, 1]))
