#include <MacTypes.h>

//
// Created by mac on 2019/9/1.
//
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    //check if the tree is symmetric
    bool isSymmetric(TreeNode *root) {
        if (root == nullptr) {
            return true;
        }
        return isSymmetric(root->left, root->right);
    }

private:
    bool isSymmetric(TreeNode *left, TreeNode *right) {
        if (!left && !right)
            return true;
        else if (!left || !right)
            return false;
        return left->val == right->val &&
               isSymmetric(left->left, right->right) &&
               isSymmetric(left->right, right->left);
    }
};


