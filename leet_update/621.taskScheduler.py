class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        t = sorted(tasks)
        tmp = []
        for x in range(len(tasks)):
            if t[x] not in tmp:
                tmp.append(t[x])
