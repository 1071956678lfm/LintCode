#include"header.h"


//Given an array of integers, 
//return indices of the two numbers such that they add up to a specific target.

//You may assume that each input would have exactly one solution, 
//and you may not use the same element twice.
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> hash;
        vector<int> ans(2);
        int n = nums.size();
        
        for(int i = 0 ; i < n ; ++i){
            hash[target - nums[i]] = i;
        }
        
        for(int i = 0 ; i <n ; ++i){
            int comple = nums[i];
            if(hash.count(comple) > 0 && 
                i != hash[comple]){
                ans[0] = i;
                ans[1] = hash[comple];
                break;
            }
        }
        return ans;        
    }
};