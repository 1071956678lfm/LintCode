#include "header.h"
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        if(NULL == head) return head;
        
        ListNode* pre = new ListNode(-1) , *post = new ListNode(-1);
        
        ListNode* p1 = pre , * p2 = post;
        
        ListNode* listPtr = head;
        
        while(listPtr){
            if(listPtr->val < x) {
                p1->next = new ListNode(listPtr->val);
                p1 = p1->next;
            }else{
                p2->next = new ListNode(listPtr->val);
                p2 = p2->next;
            }
            listPtr = listPtr->next;
        }
        
        p1->next = post->next;
        return pre->next;
    }
};