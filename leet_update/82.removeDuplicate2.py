# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        cur = head

        arr = []
        dipulates = []
        while cur != None:
            if cur.val not in arr and cur.val not in dipulates:
                arr.append(cur.val)
            elif cur.val not in dipulates:
                arr.remove(cur.val)
                dipulates.append(cur.val)
            cur = cur.next
        if len(arr) == 0:
            return None
        elif len(arr) == 1:
            return ListNode(arr[0])

        ans = ListNode(arr[0])
        p = ans
        for num in arr[1:]:
            p.next = ListNode(num)
            p = p.next
        return ans


a = ListNode(1)
a.next = ListNode(1)
a.next.next = ListNode(1)
Solution().deleteDuplicates(a)
