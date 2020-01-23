#include"header.h"

//left翻转 + right翻转 + 全部翻转即可
class Solution {
public:
    string LeftRotateString(string str, int n) {
        int len = str.length();
        n = n % len;
        if(0 == len || n == 0) return str;

        reverse(str , 0 , n - 1);
        reverse(str , n , len - 1);
        reverse(str , 0 , len - 1);
        return str;
    }
    
    void reverse(string& str , int begin , int end){
        if(begin >= end) return ;
        int l = begin , r = end;
        while(l < r){
            char ch = str[l];
            str[l] = str[r];
            str[r] = ch;
            ++l; --r;
        }
    }
};