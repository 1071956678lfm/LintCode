#include"header.h"

//2Sum , 如果有多个答案，返回乘积最小的
class Solution {
public:
    vector<int> FindNumbersWithSum(vector<int> nums, int sum) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> num2idx(n, 0);
        for (int i = 0; i < n; ++i) num2idx[i] = sum - nums[i];
        pair<int, int> ans(INT_MAX, 1);
        int found = 0;
        for (int i = 0; i < n; ++i) {
            int target = num2idx[i];
            int idx = binSearch(nums, target);
            if (idx >= 0 && i != idx) {
                found = 1;
                int maxMul = ans.first * ans.second;
                if (target * nums[i] < maxMul) ans = pair<int, int>(target, nums[i]);
            }
        }
        if(!found) return vector<int>();
        vector<int> t = {ans.first, ans.second};
        sort(t.begin() , t.end());
        return t;
    }

    int binSearch(const vector<int> &nums, int target) {
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return nums[r] == target ? r : -1;
    }
};
