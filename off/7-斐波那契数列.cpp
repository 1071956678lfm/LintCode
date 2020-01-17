#include"header.h"

class Solution {
public:
    int Fibonacci(int n) {
        int a = 0, b= 1 , c = 1;
        for(int i = 0; i < n ; ++i){
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
};