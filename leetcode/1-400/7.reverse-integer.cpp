
#include "header.h"

class Solution
{
public:
    int reverse(int x)
    {
        if (x == INT_MIN)
            return 0;
        int pos = x > 0;
        x = abs(x);
        string tmp = to_string(x);
        long long sum = 0;

        for (int i = tmp.length() - 1; i >= 0; --i)
        {
            sum *= 10;
            sum += tmp[i] - '0';
            if (overflow(sum, pos))
                return 0;
        }
        return pos ? sum : -sum;
    }

    int overflow(long long val, int pos)
    {
        if (pos)
            return val > INT_MAX;
        else
            return -val < INT_MIN;
    }
};