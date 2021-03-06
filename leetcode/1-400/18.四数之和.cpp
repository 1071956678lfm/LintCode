#include"header.h"

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        int n = nums.size();
        vector<vector<int>> ans;
        if(n < 4) return ans;
        sort(nums.begin(), nums.end());
        for(int i = 0 ; i < n ; ){
            for(int j = i + 1 ; j < n ;){
                int cur = target - nums[i] - nums[j];
                int l = j + 1  , r = n - 1;
                while(l < r){
                    int sum = nums[l] + nums[r];
                    if(cur == 3){
                        cout << l<<',' << r <<',' <<endl;
                        cout << sum  << endl;
                    }
                    if(sum < cur) ++l;
                    else if(sum > cur) --r;
                    else if(cur - sum == 0){
                            ans.push_back(
                            {nums[i] , nums[j] , nums[l] , nums[r]}
                        );
                        int a = nums[l] , 
                        b = nums[r];
                        while(l < r && nums[l] == a) ++l;
                        while(l < r && nums[r] == b) --r;
                    }
                }
                
                int k = nums[j];
                while(j < n && nums[j] == k) ++j;
            }
            int cur = nums[i];
            while(i < n && nums[i] == cur) ++i;
        }
        return ans;
    }
};