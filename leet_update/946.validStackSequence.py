class Solution(object):
    def validateStackSequences(self, pushed, popped):
        """
        :type pushed: List[int]
        :type popped: List[int]
        :rtype: bool
        """
        stack = []
        index_push = 0
        index_pop = 0
        while index_pop < len(popped):
            val = popped[index_pop]
            if (len(stack) == 0 or stack[-1] != val) and index_push < len(pushed):
                stack.append(pushed[index_push])
                index_push += 1
            elif stack[-1] == val:
                stack.pop()
                index_pop += 1
            else:
                return False
        return index_pop == len(popped)


ans = Solution().validateStackSequences([1, 2, 3, 4, 5], [4, 3, 5, 2, 1])
print(ans)
