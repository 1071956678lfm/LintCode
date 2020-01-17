#include"header.h"

class Solution {
public:
    TreeNode *reConstructBinaryTree(vector<int> pre, vector<int> vin) {
        if (pre.empty())return nullptr;
        TreeNode *root = new TreeNode(pre.front());
        if (vin.size() == 1) return root;
        int pivot = pre.front();
        int idx = 0;
        for (int i = 0; i < vin.size(); ++i, ++idx) {
            if (vin[i] == pivot) break;
        }
        int n = pre.size();
        int len1 = idx, len2 = pre.size() - 1 - len1;
        root->left = reConstructBinaryTree(subVec(pre, 1, 1 + len1),
                                           subVec(vin, 0, len1));
        root->right = reConstructBinaryTree(subVec(pre, n - len2, n),
                                            subVec(vin, n - len2, n));
        return root;
    }

    vector<int> subVec(const vector<int> &vec, int begin, int end) {
        return vector<int>(vec.begin() + begin,
                           vec.begin() + end);
    }
};