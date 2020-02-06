#include"header.h"

class Solution {
public:
    vector<vector<int>> ans;
    vector<int> path;
    
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        int n = nums.size();
        if(nums.empty()) return ans;
        sort(nums.begin(), nums.end());        
        dfs(nums, target , 0);
        return ans;
    }
    
    void dfs(const vector<int>& nums, int target , int idx){
        if(0 == target){
            ans.push_back(path);
        }
        
        for(int i = idx; i < nums.size(); ++i){
            int num = nums[i];
            if(num <= target){
                path.push_back(num);
                dfs(nums , target - num, i);
                path.pop_back();
            }else break;
        }
        
    }
};