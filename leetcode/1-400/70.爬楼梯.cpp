#include"header.h"

class Solution {
public:
    int climbStairs(int n) {
        long long a = 1, b =1 , c = a + b;
        for(int i = 0; i< n; ++i){
            c = a + b;
            a = b;
            b = c;
        }
        return a;
        
    }
};