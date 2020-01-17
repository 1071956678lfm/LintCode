#include"header.h"

//输入一个链表，输出该链表中倒数第k个结点
//双指针
class Solution {

public:
    ListNode *FindKthToTail(ListNode *head, unsigned int k) {
        int pre = -k, pos = 0;
        if (!head) return NULL;
        ListNode *ptr = new ListNode(-1);   //虚拟头节点
        ptr->next = head;
        ListNode *ans = NULL;

        while (ptr) {
            ptr = ptr->next;
            if(!ptr) break;
            if (ans)
                ans = ans->next;
            ++pos;
            ++pre;
            if (pre == 0)
                ans = head;
        }

        return ans;
    }
};