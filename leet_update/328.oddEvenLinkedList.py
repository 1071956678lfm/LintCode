# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        odds_head = ListNode(0)
        evens_head = ListNode(0)

        odd_ptr = odds_head
        even_ptr = evens_head
        is_odd = True
        while head:
            if is_odd:
                odd_ptr.next = ListNode(head.val)
                odd_ptr = odd_ptr.next
            else:
                even_ptr.next = ListNode(head.val)
                even_ptr = even_ptr.next
            is_odd = not is_odd
            head = head.next

        even_ptr.next = None
        odd_ptr.next = evens_head.next
        return odds_head.next
