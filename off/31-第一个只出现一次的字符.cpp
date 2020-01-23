#include"header.h"

class Solution {
public:
    int FirstNotRepeatingChar(string str) {
        int n = str.length();
        map<char, int> map;
        for (int i = 0; i < n; ++i) {
            int val = map[str[i]];
            map[str[i]] = val + 1;
        }
        char ch = 0;
        for (int i = 0; i < n; ++i) {
            if (map[str[i]] == 1) {
                return i;
            }
        }
        return -1;

    }
};
