#include"header.h"

//使用两点法即可
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* newHead = new ListNode(-1);
        newHead->next = head;
        auto ptr = newHead;
        int cnt = -n;
        
        while(cnt != 1){
            ptr = ptr->next;
            ++cnt;
        }
        //此时ptr和pre恰好相差 n
        ListNode* pre = newHead;
        while(ptr){
            ptr = ptr->next;
            pre = pre->next;
        }
        pre->next = pre->next == NULL ? NULL : pre->next->next;
        return newHead->next;
    }
};