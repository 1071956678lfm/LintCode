#include"header.h"

struct RandomListNode{
    RandomListNode* next;
    RandomListNode* random;
    int label;

    RandomListNode(int label):label(label),next(NULL) , random(NULL){};  
};

typedef RandomListNode rln;

class Solution {
public:
    RandomListNode *Clone(RandomListNode *pHead) {
        if(pHead==NULL) return NULL;
        rln* ptr = pHead;
        while(ptr){
            rln* newNode = new rln(ptr->label);
            newNode->next = ptr->next;
            ptr->next = newNode;
            ptr = newNode->next;
        }
        ptr = pHead;
        while(ptr){
            if(ptr->random)
                ptr->next->random = ptr->random->next;  
            ptr = ptr->next->next;
        }
        //select
        rln* head = pHead->next;
        ptr = pHead;
        while(ptr->next){
            rln* pNext = ptr->next;
            ptr->next = pNext->next;
            ptr = pNext;
        }
        return head;
    }
};
