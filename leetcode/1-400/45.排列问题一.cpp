#include"header.h"

class Solution {
    vector<vector<int>> ans;
    vector<int> path;
    vector<int> visited;
    int n ;
public:
    vector<vector<int>> permute(vector<int>& nums) {
        this->n = nums.size();
        if(n == 0) return ans;
        visited.resize(n , 0);
        dfs(nums);
        return ans;
    }
    
    void dfs(const vector<int>& nums){
        if(path.size() == n){
            ans.push_back(path);return;
        }
        
        for(int i = 0 ; i < n ; ++i){
            if(!visited[i]){
                visited[i] = 1;
                path.push_back(nums[i]);
                dfs(nums);
                path.pop_back();
                visited[i] = 0;
            }
        }
    }
};