#include"header.h"
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if(!head || k == 0) return head;
        ListNode* newHead = new ListNode(-1);
        newHead->next = head;
        ListNode* pre = newHead , *ptr = pre->next;
        int cnt = 0;
        for(ListNode* p = head; p ; p = p->next) ++cnt;
        if(k % cnt == 0) return head;
        k = cnt - (k % cnt);
        cnt = 0;
        while(cnt < k){
            ptr = ptr->next;
            pre = pre->next;
            ++cnt;
        }
        ListNode* tmp = ptr;    //new Head;
        while(ptr->next){
            ptr = ptr->next;
        }
        ptr->next = head;
        pre->next = NULL;
        return tmp;
    }
};