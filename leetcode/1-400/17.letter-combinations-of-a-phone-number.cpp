#include"header.h"

class Solution {
public:
    int n ;
    vector<string> ans;
    string path;
    
    const vector<vector<string>> hash = {
        {},{},
        {"a","b","c"},
        {"d","e","f"},
        {"g","h","i"},
        {"j","k","l"},
        {"m","n","o"},
        {"p","q","r","s"},
        {"t","u","v"},
        {"w","x","y","z"}
    };
    
    vector<string> letterCombinations(string digits) {
        n = digits.length();
        if(n == 0)return ans;
        dfs(digits, 0);
        return ans;
    }
    
    void dfs(string& str , int idx){
        if(idx == n){
            ans.push_back(path);
            return ;
        }
        for(auto s : hash[str[idx] - '0']){
            string base = path;
            path += s;
            dfs(str, idx + 1);
            path = base;
        }
        
    };
};