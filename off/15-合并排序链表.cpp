#include"header.h"

class Solution {
public:
    ListNode* Merge(ListNode* p1, ListNode* p2)
    {
        ListNode* ans=  new ListNode(-1);
        
        ListNode* ptr = ans;
        while(p1 && p2){
            if(p1->val == p2->val){
                ptr->next =new ListNode(p1->val); p1 = p1->next;
                ptr = ptr->next;
                ptr->next = new ListNode(p2->val); p2 = p2->next;
            }else if(p1->val < p2->val){
                ptr->next =new ListNode(p1->val); p1 = p1->next;
            }else if(p1->val > p2->val){
                ptr->next = new ListNode(p2->val); p2 = p2->next;
            }
            ptr = ptr->next;
        }
        
        while(p1){
             ptr->next =new ListNode(p1->val); 
            p1 = p1->next;
                ptr = ptr->next;
        }
        
        while(p2){
            ptr->next = new ListNode(p2->val); p2 = p2->next;ptr = ptr->next;
        }return ans->next;
    }
};