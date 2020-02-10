#include"header.h"

class Solution {
public:
    bool isNumber(string s) {
        trim(s);
        int idx = 0 , n = s.length();
        if(n == 0) return 0;
        if(s[0] == '-' || s[0] == '+') s = s.substr(1 , n - 1);
        n = s.length();
        if(n == 0) return 0;
        if(n == 1 && !(s[idx] >= '0' && s[idx] <= '9')) return 0;
        cout << s << endl;
        int hasDot = 0 , hasE = 0, hasNum = 0;
        while(idx < n){
            if(s[idx] == '.') {
                if(hasE || hasDot) return 0;
                hasDot ++;
                ++idx;

            }else if(s[idx] == 'e'){
                if(hasE || !hasNum) return 0;
                hasE++;
                ++idx;
                if(idx == n) return 0;
                else if(s[idx] == '+' || s[idx] == '-'){
                    if(idx == n - 1) return 0;
                    ++idx;
                }
                
            }else if(s[idx] >= '0' && s[idx] <= '9'){
                hasNum ++;
                ++idx;
            }
            else return 0;
        }
        
        return 1;
    }
    
    void trim(string& s){
        int n = s.length() , l = 0  , r = n - 1;
        
        while(l < n && s[l] == ' ') ++l;
        while(r >= 0 && s[r] == ' ') --r;
        
        s = s.substr(l , r - l + 1);
    }
};