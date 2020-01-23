#include"header.h"

//输入一棵二叉树，求该树的深度。
//从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
class Solution {
public:
    int TreeDepth(TreeNode* pRoot){
        if(NULL == pRoot) return 0;
        TreeNode* nullNode = new TreeNode(INT_MIN);
        TreeNode* ptr = pRoot;
        queue<TreeNode*> queue;
        queue.push(ptr);
        queue.push(nullNode);
        int cnt = 0;
        while(ptr){
            auto front = queue.front();
            if(isNull(front)){
                if(queue.size() == 1) {
                    break;
                }else{
                    ++cnt;
                    queue.pop();
                    queue.push(nullNode);
                }
            }else{
                queue.pop();
                if(front->left) queue.push(front->left);
                if(front->right) queue.push(front->right);
            }         
        }
        return 1 + cnt;
    }
    
    int isNull(TreeNode* node){
        return node->val == INT_MIN;
    }
};