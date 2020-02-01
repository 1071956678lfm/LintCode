#include"header.h"


class Solution {
public:
    vector<string> ans;
    string path;
    int len;
    vector<string> generateParenthesis(int n) {
        len = n;
        dfs(0 , 0);
        return ans;
    }
    
    void dfs(int left , int right){
        if(len * 2 == path.length()){
            ans.push_back(path);
            return ;
        }
        string base = path;
        if(left < len) {
            path += '(';
            dfs(left + 1 , right);
            path = base;
        }
        if(left > right && right < len){
            path += ')';
            dfs(left ,right + 1);
            path = base;
        }
    }
    
    string dupli(char ch , int times){
        string ans;
        for(int i = 0 ; i < times;++i) ans+=ch;
        return ans;
    }
};