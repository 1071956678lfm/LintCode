class Solution(object):
    def summaryRanges(self, nums):
        """
        Given a sorted integer array without duplicates, return the summary of its ranges.

        Example 1:

        Input:  [0,1,2,4,5,7]
        Output: ["0->2","4->5","7"]
        Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
        Example 2:

        Input:  [0,2,3,4,6,8,9]
        Output: ["0","2->4","6","8->9"]
        Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
        :type nums: List[int]
        :rtype: List[str]

        """
        ans = []
        if len(nums) == 0:
            return ans
        is_cotinuous = True
        cur = nums[0]
        t = [cur, cur]
        for i in nums[1:]:
            # if is_cotinuous == False:
                # t[0] = t[1] = i
            if cur == i-1:
                t[1] += 1
                cur = i
                is_cotinuous = True
            else:
                is_cotinuous = False
                if t[0] == t[1]:
                    ans.append(str(t[0]))
                else:
                    ans.append('->'.join([str(s) for s in t]))
                t[0] = t[1] = cur = i
        if t[0] == t[1]:
            ans.append(str(t[0]))
        else:
            ans.append('->'.join([str(s) for s in t]))
        return ans


arr = [-1]
t = Solution().summaryRanges(arr)
print(t)
