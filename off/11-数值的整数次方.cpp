#include"header.h"

//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

//保证base和exponent不同时为0
class Solution {
public:
    double Power(double base, int exp) {
        if(base * exp == 0) return exp == 0 ? 1 : base;
        int n = abs(exp);
        
        double ans = base;
        //快速幂
        while(n){
            if(n == 1){
                break;
            }else if(n & 1 == 1){
                ans = ans * ans * ans;
                n >>= 1;
            }else if(n & 1 == 0){
                ans = ans * ans;
                n >>= 1;
            }
        }
     
        return exp > 0 ? ans : 1/ans;
    }
};