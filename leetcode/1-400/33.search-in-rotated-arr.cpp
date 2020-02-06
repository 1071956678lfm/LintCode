#include"header.h"

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0 , r=  nums.size() - 1;
        if(nums.empty()) return -1;
        if(nums.back() == target) return r;
        
        while(l < r ){
            int mid = l + r >> 1;
            
            if(nums[mid] <= nums.back()) r = mid;
            else l = mid + 1;
        }
        //find min element
        if(nums[r] == target) return r;
        else if(nums.back() > target){
            r = nums.size() - 1;
        }else {
            l = 0;
            --r;
        }
        while(l < r){
            int mid = l + r + 1>> 1;
            if(nums[mid] <= target) l = mid;
            else r=  mid - 1;
        }
        return nums[l] == target ? l : -1;
    }
};