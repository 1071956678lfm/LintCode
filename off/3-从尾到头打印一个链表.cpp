#include"header.h"
static inline 
void swap(int* a, int * b){
    int tmp = *a;
    *a = *b ;
    *b= tmp;
}
    
class Solution {
public:
    vector<int> printListFromTailToHead(ListNode* head) {
        vector<int> ans;
        ListNode* ptr = head;
        while(ptr!=NULL){
            ans.push_back(ptr->val);
            ptr = ptr->next;
        }
        int n = ans.size();
        for(int i = 0;i < n / 2; ++i){
            swap(&ans[i] , &ans[n - i - 1]);
        }
        
        return ans;
    }
};