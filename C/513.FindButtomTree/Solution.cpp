//
// Created by mac on 2019/9/16.
//
#include <iostream>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    /**
     * 查找到树最深的一层的最左侧节点
     * 思路: 二叉树的层次序遍历.
     * 但是有所不同的是, 需要判定每一层的开始位置
     * 所以我们在每一层queue push 进入之后，添加一个nullptr来进行标记
     * @return: 节点value
     * */
    int findBottomLeftValue(TreeNode *root);

    //普通的层次遍历
    void levelPrint(TreeNode *root);
};

int Solution::findBottomLeftValue(TreeNode *root) {
    queue<TreeNode *> queue;
    auto *ans = new TreeNode(0);
    queue.push(root);
    queue.push(nullptr);
    bool endFlag = true;
    while (!queue.empty()) {
        //visit
        TreeNode *node = queue.front();
        queue.pop();
        if (node) {//第一个不是空
            if (endFlag && queue.back() == nullptr) {
                ans->val = node->val;
                endFlag = false;
            }
            //push back
            if (node->left) {
                queue.push(node->left);
                endFlag = false;
            }
            if (node->right) {
                queue.push(node->right);
                endFlag = false;
            }
        }
        if (queue.size() == 1)
            break;
        if (queue.front() == nullptr) {
            queue.pop();
            queue.push(nullptr);
            endFlag = true;
        }

    }
    return ans->val;
}

void Solution::levelPrint(TreeNode *root) {
    queue<TreeNode *> queue;

    queue.push(root);
    while (!queue.empty()) {
        //visit
        TreeNode *node = queue.front();
        cout << node->val << ",";
        //pop
        queue.pop();
        //push back
        if (node->left)
            queue.push(node->left);
        if (node->right)
            queue.push(node->right);
    }
}
