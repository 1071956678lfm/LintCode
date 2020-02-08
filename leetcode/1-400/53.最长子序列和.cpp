#include"header.h"

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if(nums.empty()) return 0;
        int n = nums.size();
        vector<int> dp(n + 1);
        for(int i = 1 ; i <= n ; ++i){
            dp[i] = max(0, dp[i - 1]) + nums[i - 1];
        }
        int ans = INT_MIN;
        for(int i = 1; i <= n ; ++i){
            ans = max(ans , dp[i]);
        }
        return ans;
    }
};