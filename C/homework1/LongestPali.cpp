//
// Created by mac on 2019/9/22.
//
#include <iostream>

using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {

        string longest = "";

        if (s.length() <= 1 || s == "") { return s; }

        for (int i = 0; i < s.length(); i++) {
            string temp = expand(s, i, i);

            if (temp.length() > longest.length()) { longest = temp; }

            temp = expand(s, i, i + 1);

            if (temp.length() > longest.length()) { longest = temp; }
        }
        return longest;
    }

    string expand(string str, int begin, int end) {

        while (begin >= 0 && end <= str.length() - 1 && str[begin] == str[end]) {
            begin--;
            end++;
        }

        return str.substr(begin + 1, (end - begin) - 1);
    }
};
