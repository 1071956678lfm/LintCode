#include"header.h"

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.empty()) return {-1, -1};
        int n = nums.size();
        int l = 0 ,  r=  n -1 , left = -1,right = -1;        
        //first
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if(nums[l] != target) return {-1 , -1};
        left = l;
        r = n - 1;
        while(l < r){
            int mid= l + r + 1 >> 1;
            if(nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        right = r ;
        return {left , right};
    }
};