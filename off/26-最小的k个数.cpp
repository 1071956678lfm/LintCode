#include"header.h"

class Solution {
public:
    vector<int> GetLeastNumbers_Solution(vector<int> nums, int k) {
        sort(nums.begin() , nums.end());
        vector<int> ans;
        if(k > nums.size()) return ans;
        return vector<int>(nums.begin(), nums.begin() + k);
    }
};