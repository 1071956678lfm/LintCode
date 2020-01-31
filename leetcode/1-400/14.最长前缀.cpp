#include "header.h"
//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
//Exp: 
//Input :
    //["flower","flow","flight"]
//Output: "fl"
class Solution
{
public:
    string longestCommonPrefix(vector<string> &strs)
    {
        if (strs.empty())
            return "";
        int n = strs.size();
        if (n == 1)
            return strs.front();
        else if (n == 2)
        {
            string s1 = strs[0], s2 = strs[1];
            return longestCommonPrefix(s1, s2);
        }
        int mid = n >> 1;
        vector<string> str_l = vector<string>(strs.begin(),
                                              strs.begin() + mid);
        vector<string> str_r = vector<string>(strs.begin() + mid,
                                              strs.end());
        string left = longestCommonPrefix(str_l),
               right = longestCommonPrefix(str_r);
        return longestCommonPrefix(left, right);
    }
    string longestCommonPrefix(string &s1, string &s2)
    {
        int i = 0;
        for (; i < s1.length() && i < s2.length(); ++i)
        {
            if (s1[i] != s2[i])
            {
                return s1.substr(0, i);
            }
        }
        return i == s1.length() ? s1 : s2;
        return s1;
    }
};