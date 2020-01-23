#include"header.h"

class Solution {
public:
    ListNode* FindFirstCommonNode( ListNode* p1, ListNode* p2) {
        int a = 0 , b = 0;
        ListNode* node1=  p1 , *node2 = p2;
        while(node1){
            ++a;
            node1 = node1->next;
        }
        while(node2){
            ++b;
            node2 = node2->next;
        }
        ListNode* longNode , *shortNode;
        if(a == b) return p1;
        else if(a < b){
            longNode = p2;
            shortNode = p1;
        }else{
            longNode = p1;
            shortNode = p2;
        }
        int offset = abs(a-b);
        for(int i = 0 ; i < offset ; ++i) longNode = longNode->next;
        
        while(shortNode && longNode){
            if(shortNode == longNode) return shortNode;
            shortNode = shortNode->next;
            longNode = longNode->next;
        }
        return NULL;
        
    }
};