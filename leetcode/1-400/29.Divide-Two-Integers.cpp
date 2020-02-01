#include"header.h"

class Solution {
public:
    int divide(int dividend, int divisor) {
        int p1 = dividend > 0 , p2 = divisor > 0;
        int pos = !(p1 ^ p2);
        long long d1 = abs((long long) dividend);
        long long d2 = abs((long long) divisor);
        long long cnt = 0;
        
        if(d1 % d2 == 0) {
            cnt = d1 / d2;
            d1 %= d2;
        }
        while(d1 >= d2){
            d1 -= d2; ++cnt;
        }
        cnt = pos ? cnt : -cnt;
        if(cnt > INT_MAX || cnt < INT_MIN){
            cnt = cnt > INT_MAX ? INT_MAX : INT_MIN;
        }
        return cnt;
    }