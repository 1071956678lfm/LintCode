#include"header.h"
/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * 
*/
class Solution {
public:
    vector<vector<int> > ans;
    vector<int> path;

    vector<vector<int> > FindPath(TreeNode *root, int n) {
        dfs(root, n);
        sort(ans.begin(), ans.end(), [](auto &v1, auto &v2) {
            return v1.size() > v2.size();
        });
        return ans;
    }

    void dfs(TreeNode *root, int n) {
        if(!root || root->val > n) return;
        if(!root->left && !root->right && root->val == n){
            path.push_back(n);
            ans.push_back(path);
            path.pop_back();
            return;
        }
        int val = root->val;
        
        path.push_back(val);
            dfs(root->left, n - val);
        path.pop_back();
        
        path.push_back(val);
           dfs(root->right, n - val);
        path.pop_back();
    }
};
