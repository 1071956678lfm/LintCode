#include"header.h"

//每 K 个进行链表翻转
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(0==k || !head) return head;
        ListNode* newHead = new ListNode(-1);
        newHead->next = head;
        ListNode* pre = newHead ;
        for(ListNode* next = findNextK(pre , k) ,
                    * p = pre->next;
           next != NULL ;
           next = findNextK(pre , k) , p = pre->next){
            reverse(pre , k);
            pre = p;
        }
        return newHead->next;
    }
    
    //pre: The pre Node.
    ListNode* reverse(ListNode* pre , int k){
        ListNode* ptr = findNextK(pre , k);
        if(!ptr) return pre;
        int cnt = 0;
        ListNode* newHead = ptr, *rear = newHead->next;
        ptr = pre->next;
        while(cnt < k && ptr){
            ListNode* tmp = ptr->next;
            ptr->next = rear;
            rear = ptr;
            ptr = tmp;
            ++cnt;
        }
        pre->next = newHead;
        return pre;
    }
    
    ListNode* findNextK(ListNode* pre , int k){
        ListNode* ptr = pre;
        int cnt = 0;
        while(cnt < k && ptr){
            ptr = ptr->next;
            ++cnt;
        }
        return cnt < k ? NULL : ptr;
    }
};