#include"header.h"

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        int n = nums.size(), end = 1 << n;
        for(int i = 0 ; i < end ; ++i){
            vector<int> path;
            for(int j = 0 ; j < n ; ++j){
                int bit = (i >> j) & 1;
                if(bit) path.push_back(nums[j]);
            }
            ans.push_back(path);
        }
        return ans;
    }
};