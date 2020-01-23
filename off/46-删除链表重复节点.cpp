#include"header.h"

//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
//例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
class Solution {
public:
    ListNode* deleteDuplication(ListNode* pHead)
    {
        ListNode* newHead = new ListNode(-1);
        newHead->next = pHead;
        auto pre = newHead;
        if(pre == NULL)
            return newHead->next;
        while(pre->next){
            auto begin = pre->next;
            auto end = begin->next;

            if(end == NULL || begin->val != end->val){
                pre = pre->next;
            }else{
                int beginVal = begin->val;
                auto tmpPtr = begin;
                //end ptr move
                while(end){
                    if(end->val != beginVal)
                        break;
                    end = end->next;
                    tmpPtr = tmpPtr->next;
                }
                pre->next = end;
//                pre = tmpPtr;
            }
        }
        return newHead->next;
    }
};