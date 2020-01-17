#include"header.h"
class Solution {
public:
    bool HasSubtree(TreeNode *r1, TreeNode *r2) {
        if(r1 && r2)
            return isSame(r1, r2) ||
                   isSame(r1->left, r2) ||
                   isSame(r1->right, r2);
        else return false;
    }

    bool isSame(TreeNode *r1, TreeNode *r2) {
        if(!r2) return 1;
        if (!r1 || (r1->val != r2->val)) return false;
        return isSame(r1->left, r2->left) &&
               isSame(r1->right, r2->right);
    }
};
