#include "header.h"

class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        int n = s.length();
        if (0 == n)
            return 0;
        int left = 0, right = 0, ans = 0;

        map<int, int> hash;
        while (left < n && right < n)
        {
            if (left == right)
            {
                hash.clear();
            }
            while (right < n &&
                   hash[s[right]] == 0)
            {
                hash[s[right]]++;
                ++right;
            }
            ans = max(ans, right - left);
            if (right >= n)
                break;
            hash[s[left]]--;
            cout << s[left] << endl;
            ++left;
            cout << left << ',' << right << endl;
        }
        return max(ans, right - left);
    }
};