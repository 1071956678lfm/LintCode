#include"header.h"

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* p1 = l1 , *p2 = l2;
        ListNode* result = new ListNode(-1);
        ListNode* ptr = result;
        while(p1 && p2){
            int v1 = p1->val , v2 = p2->val;
            if(v1 < v2){
                ptr->next = new ListNode(v1);
                p1 = p1->next;
            }else{
                ptr->next = new ListNode(v2);
                p2 = p2->next;
            }
            ptr = ptr->next;
        }
        if(p1) ptr->next = p1;
        else ptr->next = p2;
        
        return result->next;
    }
};