
#include <iostream>

using namespace std;
class Solution {
public:
    string longestPalindrome(string s) {
        int size = s.size();
        if (size < 2) {
            return s;
        }
        bool dp[size][size];
        int maxLen = 1, start = 0;
        for (int i = 0; i < size; ++i) {
            dp[i][i] = true; //单个字符本身
            for (int j = 0; j < i; ++j) {
                if (s[i] == s[j] && (i - j == 1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                    }
                } else {
                    dp[j][i] = false;
                }
            }
        }
        return s.substr(start, maxLen);
    }
};

