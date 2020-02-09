#include"header.h"

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int i = 0 , n = nums.size();
        for(int r = 0 ; i <= r && i < n ; ++i){
            r = max(nums[i] + i , r);
        }
        return i == n;
    }
};