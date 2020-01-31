#include"header.h"

//二叉搜索树判定
//使用区间的思想来进行判定
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        if(root == NULL) return 1;
        return dfs(root , LONG_MIN , LONG_MAX);
    }
    
    bool dfs(TreeNode* root , long left ,long right){
        if(root == NULL) return 1;
        else if(root->val <= right && root->val >= left){
            return dfs(root->left , left , (long)root->val - 1) &&
                dfs(root->right , (long)root->val + 1 , right);
        }
        return 0;
    };
};