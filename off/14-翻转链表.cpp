#include"header.h"

class Solution {
public:
    ListNode* ReverseList(ListNode* pHead) {
        return iter(pHead);
    }
    
    ListNode* recur(ListNode* head){
        return NULL;
    }
    
    ListNode* iter(ListNode* head){
        ListNode* newHead = NULL;
        ListNode* ptr = head;
        
        while(ptr){
            ListNode* next = ptr->next;
            ptr->next = newHead;
            newHead  = ptr;
            ptr = next;
        }
        return newHead;
    }
};