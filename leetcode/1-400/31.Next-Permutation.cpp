#include"header.h"

//[1,2,3] => [1,3,2]
//1.从后往前进行查找，找到第一个 nums[i] < nums[i + 1] 的数。在 【i】 位置，找到它后面第一个大于它并且最接近的数，把他们进行交换.
//2. 对 begin() + i + 1, end() 进行排序即可
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        if(n <= 1) return;
        else if(2 == n){
            swap(nums[0], nums[1]);
            return ;
        }
        int idx = n - 2;
        while(idx >= 0 && nums[idx] >= nums[idx + 1]) 
            --idx;
        if(-1 == idx){
            reverse(nums.begin() , nums.end());
            return ;
        }
        int pos = getNextBig(nums , idx);
        swap(nums[pos] , nums[idx]);
        sort(nums.begin() + idx + 1 , nums.end());
    }
    
    void swap(int& a , int& b){
        int tmp = a;
        a = b;
        b = tmp;
    }
    
    int getNextBig(const vector<int>& nums , int idx){
        int target = nums[idx];
        int nextVal = INT_MAX , ans = -1;
        for(int i = idx + 1 ; i < nums.size(); ++i){
            if(target < nums[i] && nextVal > nums[i]) {
                nextVal = nums[i];
                ans = i;
            }
        }
        return ans;
    }
};