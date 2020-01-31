
#include "header.h"

class Solution
{
public:
    bool isPalindrome(int x)
    {
        if (x < 0)
            return 0;
        int cnt = 0, tmp = x;
        while (tmp)
        {
            tmp /= 10;
            ++cnt;
        }
        int l = cnt - 1 >> 1, r = cnt >> 1;
        tmp = x;
        stack<int> st;
        for (int i = 0; i <= l; ++i)
        {
            int val = tmp % 10;
            st.push(val);
            tmp /= 10;
        }
        if (l == r)
            st.pop();
        for (int i = r; i < cnt && !st.empty(); ++i)
        {
            auto top = st.top();
            st.pop();
            if (top != tmp % 10)
                return 0;
            else
                tmp /= 10;
        }
        return 1;
    }
};