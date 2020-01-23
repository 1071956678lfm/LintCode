#include "header.h"

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
*/
class Solution
{
public:
    string PrintMinNumber(vector<int> numbers)
    {
        sort(numbers.begin(), numbers.end(), [](int &a, int &b) -> bool {
            string sA = to_string(a),
                   sB = to_string(b);
            auto conn1 = sA + sB;
            auto conn2 = sB + sA;
            return stoi(conn1) < stoi(conn2);
        });
        string ans = "";
        for (auto num : numbers)
            ans += to_string(num);
        return ans;
    }
};