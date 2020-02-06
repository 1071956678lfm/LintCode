#include"header.h"

class Solution {
public:
    string multiply(string num1, string num2) {
        int n1 = num1.length() , n2 = num2.length();
        if(num1 == "0" || num2 =="0") return "0";
        string ans;
        for(int i = n1 - 1; i >= 0; --i){
            int carry = 0;
            string tmp;
            for(int j = n2 - 1 ; j >= 0; --j){
                int cur = (num1[i] - '0') * (num2[j] - '0') + carry;
                carry = cur / 10;
                tmp = to_string(cur % 10) + tmp;
            }
            if(carry) {
                tmp = to_string(carry) + tmp;
            }
            
            int zeroCnt = (n1 - 1 - i);
            for(int i = 0 ; i < zeroCnt ; ++i) tmp += '0';
            ans = add(ans , tmp);
        }       
        
        
        return ans;
    }
    
    string add(string num1 , string num2){
        int n1 = num1.length() , n2 = num2.length();
        int carry = 0 , i = n1 - 1, j = n2 - 1;
        
        string ans;
        while(i >= 0 && j >= 0){
            int cur = (num1[i] - '0') + (num2[j] - '0') + carry;
            carry = cur / 10;
            ans = to_string(cur % 10) + ans;
            --i;
            --j;
        }
        
        while(i >= 0){
            int cur = (num1[i] - '0') + carry;
            carry = cur / 10;
            ans = to_string(cur % 10) + ans;
            --i;
        }
        
        while(j >= 0){
            int cur = (num2[j] - '0') + carry;
            carry = cur / 10;
            ans = to_string(cur % 10) + ans;
            --j;
        }
        
        if(carry) ans = to_string(carry) + ans;
        return ans;
    }
};