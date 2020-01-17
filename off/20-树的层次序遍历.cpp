#include"header.h"

class Solution {
public:
    vector<int> PrintFromTopToBottom(TreeNode* root) {
        vector<int> ans;
        queue<TreeNode*> qe;
        if(!root) return ans;
        qe.push(root);
        
        while(!qe.empty()){
            auto ptr = qe.front();
            ans.push_back(ptr->val);
            qe.pop();
            if(ptr->left)
                qe.push(ptr->left); 
            if(ptr->right)    
                qe.push(ptr->right);
            
        }
        return ans;
    }
};