//
// Created by mac on 2019/9/18.
//
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    /**
     * Given a string s and a non-empty string p,
     * find all the start indices of p's anagrams in s.
     * Strings consists of lowercase English letters only and
     *  the length of both strings s and p will not be larger than 20,100.

        The order of output does not matter.
     * */
    vector<int> findAnagrams(string s, string p){
        return vector<int>();
    }

    bool isAnagrams(string &str, string pattern);
};
//
////Sliding window
//vector<int> Solution::findAnagrams(string s, string p) {
//    int i = 0;
//    int n = s.length();
//    int m = p.length();
//    bool flag = false;
//    vector<int> ans;
//    while (i + m <= n) {
//        string ssub = s.substr(i, m);
//        if (flag &&
//            ans.size() != 0) {
//            if (s[i - 1] == s[i + m - 2]) {
//                ans.push_back(i);
//            } else {
//                flag = false;
//            }
//        } else if (isAnagrams(ssub, p)) { //确认是Anagrams
//            flag = true;
//            ans.push_back(i);
//        }
//        ++i;
//    }
//    return ans;
//}

/**
 * 判定一个字符串是否是另一个字符串的Anagrams
 * */
bool Solution::isAnagrams(string &str, string pattern) {
    if (str.length() != pattern.length())
        return false;
    //double the string
    sort(str.begin(), str.end());
    sort(pattern.begin(), pattern.end());
    return str == pattern;
}

