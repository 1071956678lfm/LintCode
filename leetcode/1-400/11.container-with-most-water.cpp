#include "header.h"

/**
 * 经典的 Two Points问题
 * 如果左右两个nums[l] , nums[r] 
 *  nums[l] < nums[r] , 那么当 r--的时候，结果只会减少.所以要 ++l
 * 
*/
class Solution
{
public:
    int maxArea(vector<int> &nums)
    {
        int n = nums.size();
        int ans = 0;
        int l = 0, r = n - 1;

        while (l < r)
        {
            int cur = min(nums[l], nums[r]) * (r - l);
            ans = max(cur, ans);
            if (nums[l] < nums[r])
                ++l;
            else if (nums[l] > nums[r])
                --r;
            else
            {
                ++l;
                --r;
            }
        }
        return ans;
    }
};