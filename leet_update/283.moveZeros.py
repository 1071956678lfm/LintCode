# 283
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        ans = []
        zeroCount = 0
        for x in nums:
            if x != 0:
                ans.append(x)
            else:
                zeroCount += 1
        for i in range(length):
            if i < len(ans):
                nums[i] = ans[i]
            else:
                nums[i] = 0


arr = [0, 1, 0, 3, 12]
Solution().moveZeroes(arr)
print(arr)
