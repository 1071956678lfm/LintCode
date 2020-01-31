#include"header.h"

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* p1 = l1 , *p2 = l2;
        
        ListNode* newHead = new ListNode(-1);
        ListNode* ptr = newHead;
        
        int carry = 0;
        while(p1 && p2){
            int cur = carry + p1->val + p2->val;
            carry = cur / 10;
            cur %= 10;
            ptr->next = new ListNode(cur);
            ptr = ptr->next;
            p1 = p1->next;
            p2 = p2->next;
        }
        
        while(p1){
            int cur = carry + p1->val;
            carry = cur / 10;
            cur %= 10;
            ptr->next = new ListNode(cur);
            ptr = ptr->next;
            p1 = p1->next;
        }
        
        while(p2){
            int cur = carry + p2->val;
            carry = cur / 10;
            cur %= 10;
            ptr->next = new ListNode(cur);
            ptr = ptr->next;
            p2 = p2->next;
        }
        while(carry){
            int cur = carry;
            carry = cur / 10;
            cur %= 10;
            ptr->next = new ListNode(cur);
            ptr = ptr->next;
        }
        
        return newHead->next;
    }
};