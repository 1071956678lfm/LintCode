#include "header.h"

class Solution
{
    const int mod = 1000000007;

public:
    int InversePairs(vector<int> data)
    {
        int n = data.size();
        vector<int> aux = data;
        return mergeSort(data, aux, 0, n - 1);
    }

    int mergeSort(vector<int> &nums, vector<int> &aux, int l, int r)
    {
        if (l >= r)
            return 0;

        int mid = (l + r) >> 1;
        int left = mergeSort(nums, aux, l, mid) % mod;
        int right = mergeSort(nums, aux, mid + 1, r) % mod;

        return (left + right + merge(nums, aux, l, mid, r)) % mod;
    }

    int merge(vector<int> &nums, vector<int> &aux, int l, int mid, int r)
    {
        for (int i = l; i <= r; ++i)
            aux[i] = nums[i];

        int ans = 0;
        int i = l, j = mid + 1;
        for (int idx = l; idx <= r; ++idx)
        {
            if (i > mid)
            {
                nums[idx] = aux[j++];
            }
            else if (j > r)
            {
                nums[idx] = aux[i++];
            }
            else if (aux[i] >= aux[j])
            {
                ans += mid - i + 1;         //aux[i] 到 aux[mid] 和 aux[j] 都是逆序对
                ans = ans % mod;
                nums[idx] = aux[j++];
            }
            else if (aux[i] < aux[j])
            {
                nums[idx] = aux[i++];
            }
        }
        return ans;
    }
};