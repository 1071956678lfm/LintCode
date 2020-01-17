#include"header.h"

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*/
class Solution {
public:
    void reOrderArray(vector<int> &nums) {
        int n = nums.size();
        vector<int> ans;
        for(auto num : nums)
            if(num & 1) ans.push_back(num);
        for(auto num: nums)
            if(!(num & 1)) ans.push_back(num);

        nums = vector<int>(ans.begin() , ans.end());
    }

};