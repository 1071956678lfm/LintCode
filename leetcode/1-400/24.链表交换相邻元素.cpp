#include "header.h"

class Solution
{
public:
    ListNode *swapPairs(ListNode *head)
    {
        if (!head || !head->next)
            return head;
        ListNode *newHead = new ListNode(-1),
                 *pre = newHead, *cur = head, *next = cur->next;
        newHead->next = head;
        while (cur && cur->next)
        {
            next = cur->next;
            ListNode *tmp = next->next;
            pre->next = next;
            next->next = cur;
            cur->next = tmp;
            //to next
            pre = cur;
            cur = tmp;
        }

        return newHead->next;
    }
};