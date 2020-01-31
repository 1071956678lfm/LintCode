#include "header.h"

class Solution
{
public:
    int myAtoi(string str)
    {
        if (str.empty())
            return 0;
        trim(str);
        int pos = -1;
        if (str[0] == '+' || str[0] <= '9' && str[0] >= '0')
            pos = 1;
        else if (str[0] == '-')
            pos = 0;

        if (pos == -1)
            return 0;
        if (str[0] == '+' || str[0] == '-')
        {
            str = str.substr(1, str.length() - 1);
        }
        int n = str.length();
        long long ans = 0;
        for (int i = 0; i < n; ++i)
        {
            if (!(str[i] <= '9' && str[i] >= '0'))
            {
                break;
            }
            ans *= 10;
            ans += str[i] - '0';
            if (overflow(ans, pos))
                return ans;
        }

        return pos ? ans : -ans;
    }

    int overflow(long long &val, int pos)
    {
        if (pos)
        {
            if (val > INT_MAX)
            {
                val = INT_MAX;
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            if (-val < INT_MIN)
            {
                val = INT_MIN;
                return 1;
            }
            else
                return 0;
        }
    }

    void trim(string &s)
    {
        int i = 0, j = s.length() - 1;
        int n = s.length();

        while (i < n && s[i] == ' ')
            ++i;
        while (j >= 0 && s[j] == ' ')
            --j;
        s = s.substr(i, j - i + 1);
    }
}