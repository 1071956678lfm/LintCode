#include"header.h"

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int n = nums.size();
        for(auto it = nums.begin();it != nums.end();){
            if((*it) == val) it = nums.erase(it);
            else ++it;
        }
        return nums.size();
    }
};