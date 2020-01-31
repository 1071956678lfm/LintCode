#include "header.h"

class Solution
{
public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2)
    {
        int n1 = nums1.size(), n2 = nums2.size();
        int l = n1 + n2 - 1 >> 1, r = n1 + n2 >> 1;
        vector<int> ans;
        int i = 0, j = 0;

        while (i < n1 && j < n2)
        {
            if (nums1[i] < nums2[j])
            {
                ans.push_back(nums1[i++]);
            }
            else
            {
                ans.push_back(nums2[j++]);
            }
        }

        while (i < n1)
            ans.push_back(nums1[i++]);
        while (j < n2)
            ans.push_back(nums2[j++]);

        return (double(ans[l]) + double(ans[r])) / 2;
    }
};