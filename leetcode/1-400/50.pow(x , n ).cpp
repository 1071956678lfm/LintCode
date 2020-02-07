#include"header.h"

class Solution {
public:
    double myPow(double x, int n) {
        if(n == 1) return x;
        else if(n == 0) return 1;
        else if(n == -1) return 1/x;
        
        double ans = ((n & 1) == 0) ? myPow(x * x , abs(n / 2)) :
                                    myPow(x * x , abs(n / 2)) * x;
        return n > 0 ? ans : 1 / ans;
    }
};