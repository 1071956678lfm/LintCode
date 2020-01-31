#include"header.h"
//找出不重复的三数之和为0的所有列表
//解法：转化为(排序后的数组的)两数之和，采用 Two Points 来进行求解
//并且每一步都跳跃到下一个不重复的位置上
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> ans;
        if(n <= 2) return ans;
        sort(nums.begin() , nums.end());
        
        for(int i = 0 ; i < n ;){
            int target = -nums[i];
            int l = i + 1 , r = n - 1;
            while(l < r){
                if(nums[l] + nums[r] < target) ++l;
                else if(nums[l] + nums[r] > target) --r;
                else{
                    ans.push_back({nums[i] , nums[l] , nums[r]});
                    int a = nums[l] , b = nums[r];
                    while(l < r && nums[l] == a) ++l;               //  跳跃到下一个不同的位置
                    while(l < r && nums[r] == b) --r;
                }
            }
            int tmp = nums[i];
            while(i < n && nums[i] == tmp) ++i;
        }
        return ans;
    }
};