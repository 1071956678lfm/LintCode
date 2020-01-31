#include"header.h"
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int n = nums.size();
        if(n <= 2) return 0;
        sort(nums.begin() , nums.end());
        int offset = INT_MAX , ans = 0 ;
        
        for(int i = 0 ; i < n ; ++i){
            int k = target - nums[i];
            int l = i + 1 , r = n - 1;
            while(l < r){
                int val = nums[l] + nums[r];
                if(offset > abs(k - val)) {
                    offset = abs(k - val);
                    ans = val + nums[i];
                }
                if(val < k) ++l;
                else if(val > k) --r;
                else return target;
            }
        }
        return ans;
    }
};