#include"header.h"

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        vector<int> ans;
        int n = digits.size();
        if(n == 0) return {1};
        int carry = 1;
        for(int i = n - 1; i >= 0 ; --i){
            int cur = carry + digits[i];
            carry = cur / 10;
            ans.push_back(cur % 10);
        }
        if(carry) ans.push_back(carry);
        reverse(ans.begin(),ans.end());
        return ans;
    }
};