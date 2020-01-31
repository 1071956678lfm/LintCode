#include "header.h"
//determine which method to go on
#define method 1

class Solution
{
public:
    string longestPalindrome(string s)
    {
        switch (method)
        {
        case 1:
            return solution1(s);
            break;
        case 2:
            return solution2(s);
            break;
        default:
            break;
        }
        return "";
    }

    //TLE. 暴力搜索
    string solution1(string &s)
    {
        if (s.size() <= 1)
            return s;
        int maxSize = 0, n = s.length();
        string ans = "";

        for (int i = 0; i < n; ++i)
        {
            for (int j = i; j < n; ++j)
            {
                if (j - i + 1 > maxSize &&
                    isParli(s.substr(i, j - i + 1)))
                {
                    ans = s.substr(i, j - i + 1);
                    maxSize = j - i + 1;
                }
            }
        }
        return ans;
    }

    //DP: 暴力搜索的优化
    string solution2(string &s)
    {
        if (s.empty())
            return "";
        int n = s.length();

        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i)
            dp[i][i] = 1;
        for (int i = 0; i + 1 < n; ++i)
            dp[i][i + 1] = (s[i] == s[i + 1]);
        for (int i = n - 1; i >= 0; --i)
        {
            dp[i][n - 1] = isParli(s.substr(i, n - i));
            for (int j = i + 2; j + 1 < n; ++j)
            {
                dp[i][j] = dp[i + 1][j - 1] && (s[i] == s[j]);
            }
        }
        string ans;
        int maxRes = INT_MIN;
        int p, q;
        for (int i = 0; i < n; ++i)
        {
            for (int j = i; j < n; ++j)
            {
                if (dp[i][j] && j - i + 1 > maxRes)
                {
                    p = i;
                    q = j;
                    maxRes = j - i + 1;
                }
            }
        }
        return s.substr(p, q - p + 1);
    }
    bool isParli(const string &s)
    {
        int l = 0, r = s.length() - 1;
        while (l < r)
        {
            if (s[l] != s[r])
                return 0;

            ++l;
            --r;
        }
        return 1;
    }
};