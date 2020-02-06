#include"header.h"

class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n <= 1) return 0;
        int jump = 0 , curFar = 0 , nextFar = 0;
        int i = 0;
        while(curFar > i - 1){
            for(;i <= curFar ; ++i){
                nextFar = max(nextFar , nums[i] + i);
                if(nextFar >= n - 1) return jump + 1;
            }
            curFar = nextFar;
            ++jump;
        }
        return 0;
    }
};