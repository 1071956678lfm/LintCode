#include"header.h"

class Solution {
public:
    int FindGreatestSumOfSubArray(vector<int> nums) {
        int n = nums.size();
        if (0 == n) return 0;
        vector<int> dp(n + 1);//1, -2, 3, 10, -4, 7, 2, -5
        for (int i = 1; i <= n; ++i) {
            dp[i] = nums[i - 1] + max(0, dp[i - 1]);
        }
        int ans = INT_MIN;
        for (int i = 1; i <= n; ++i) ans = max(ans, dp[i]);
        return ans;
    }
};
