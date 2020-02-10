#include"header.h"

#define BASE 2
class Solution {
public:
    string addBinary(string a, string b) {
        int m = a.length() , n = b.length();
        if(m == 0) return b;
        else if(n == 0) return a;
        vector<char> ans;
        int carry = 0 , i = m - 1 , j = n - 1;
        while(i >=0 && j >= 0){
            int cur = (a[i--] - '0') + (b[j--] - '0') + carry;
            carry = cur / BASE;
            ans.push_back(cur % BASE + '0');
        }
        while(i >= 0){
            int cur = a[i--] -'0' + carry;
            carry = cur / BASE;
            ans.push_back(cur % BASE+ '0');
        }
        while(j >= 0) {
            int cur = b[j--] - '0' +carry;
            carry = cur / BASE;
            ans.push_back(cur % BASE+ '0');
        }
        if(carry) ans.push_back(carry + '0');
        reverse(ans.begin() , ans.end());
        string tmp;
        for(int i = 0; i < ans.size(); ++i) tmp += ans[i];
        return tmp;
    }
};