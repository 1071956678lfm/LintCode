#include"header.h"

class Solution {
public:
    bool IsBalanced_Solution(TreeNode* pRoot) {
          return -1 != depth(pRoot);        
    }
    
    int depth(TreeNode* root){
        if(root == NULL) return 0;
        int left = depth(root->left);
        if(left == -1) return -1;
        int right = depth(root->right);
        if(right == -1) return -1;
        if(abs(left - right) > 1) return -1;
        
        return 1 + max(left ,right);
    }
};