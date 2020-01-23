#include"header.h"
//将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 
//数值为0或者字符串不是一个合法的数值则返回0
class Solution {
public:
    int StrToInt(string str) {
        if (str.empty()) return 0;
        int n = str.length();
        int pos = str[0] == '-' ? 0 : 1;
        if (str[0] == '-' || str[0] == '+')
            str = str.substr(1, n - 1);
        n = str.length();
        if (str[0] == '0') return 0;
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!(str[i] >= '0' && str[i] <= '9'))
                return 0;
            int tmp = str[i] - '0';
            ans *= 10;
            ans += tmp;

            if (ans > -(long) INT_MIN)
                return 0;
        }
        ans = pos ?
              (ans > (long) INT_MAX ? 0 : ans) :
              (ans > -(long) INT_MIN ? 0 : -ans);
        return ans;
    }
};