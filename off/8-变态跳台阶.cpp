#include"header.h"

//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
//求该青蛙跳上一个n级的台阶总共有多少种跳法。
class Solution {
public:
    int jumpFloorII(int n) {
        vector<int> dp(n + 1);

        for (int i = 1; i <= n; ++i) {
            dp[i] = 1;
            for (int j = 1; j <= i; ++j) dp[i] += dp[i - j];
        }
        return dp[n];
    }
};