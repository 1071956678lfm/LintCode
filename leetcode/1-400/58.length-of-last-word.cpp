#include"header.h"

class Solution {
public:
    int lengthOfLastWord(string s) {
        int n = s.length();
        if(n == 0) return 0;
        int idx = n - 1;
        while(idx >= 0 && s[idx] ==' ') {
            --n; --idx;
        }
        
        while(idx >= 0 && s[idx] != ' ') --idx;
        return n - idx - 1;
    }
};