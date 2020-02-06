#include"header.h"

class Solution {
public:
    int trap(vector<int>& nums) {
        int n = nums.size();
        if(n <= 2) return 0;
        vector<int> leftH(n, nums[0]) , rightH(n , nums[n - 1]);
        for(int i = 1 ; i < n; ++i){
            leftH[i] = max(leftH[i - 1] , nums[i]);
        }
        
        for(int i = n - 2 ; i >= 0; --i){
            rightH[i] = max(rightH[i + 1] , nums[i]);
        }
        int ans = 0;
        for(int i = 0 ; i < n ; ++i){
            ans += min(leftH[i],rightH[i]) - nums[i];
        }
        return ans;
    }
};