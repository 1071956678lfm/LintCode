#include"header.h"

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int n = lists.size();
        ListNode* head = new ListNode(1);
        ListNode* ptr = head;
        
        while(!isAllNull(lists)){
            int idx = findSmallest(lists);
            if(lists[idx]){
                ptr->next = new ListNode(lists[idx]->val);
                ptr = ptr->next;
                lists[idx] = lists[idx]->next;
                
                if(!lists[idx]){
                    lists.erase(lists.begin() + idx);
                }
            }        
        }
        
        return head->next;
    }
    
    int isAllNull(const vector<ListNode*>& lists){
        for(ListNode* node : lists){
            if(node != NULL) return 0;
        }
        return 1;
    }
    
    int findSmallest(vector<ListNode*> lists){
        int minVal = INT_MAX , idx = 0;
        for(int i = 0; i < lists.size() ; ++i){
            ListNode* ptr = lists[i];
            if(ptr && minVal > ptr->val){
                minVal = ptr->val;
                idx = i;
            }
        }
        return idx;
    }
};