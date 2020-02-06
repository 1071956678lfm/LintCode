#include"header.h"


class Solution {
public:
    vector<vector<int>> ans;
    vector<int> path;
    vector<vector<int>> combinationSum2(vector<int> &nums, int target) {
        if (nums.empty()) return ans;
        sort(nums.begin(), nums.end());
        dfs(nums, target, 0);
        return ans;
    }

    void dfs(const vector<int> &nums, int target, int idx) {
        if (0 == target) {
            ans.push_back(path);
            return;
        }
        int n = nums.size();
        for (int i = idx; i < n; i++) {
            int num = nums[i];
            if(i > idx && nums[i] == nums[i - 1]) continue;
            if (num <= target) {
                path.push_back(num);
                dfs(nums, target - num, i + 1);
                path.pop_back();
            } else break;
        }
    }
};
