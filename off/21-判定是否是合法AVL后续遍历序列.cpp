#include"header.h"
class Solution {
public:
    bool VerifySquenceOfBST(vector<int> nums) {
        if (nums.empty()) return 0;
        return VerifySquenceOfBST(nums, 0, nums.size() - 1);
    }

    bool VerifySquenceOfBST(const vector<int> &nums, int l, int r) {
        if (l >= r) return 1;
        int back = nums[r];
        int idx = r - 1;
        while (idx >= l) {
            if (nums[idx] > back) --idx;
            else break;
        }
        for (int i = l; i <= idx; ++i) {
            if (nums[i] > back) return 0;
        }
        return VerifySquenceOfBST(nums, l, idx) &&
               VerifySquenceOfBST(nums, idx + 1, r - 1);
    }
};