#include"header.h"

class Solution {
public:
    string simplifyPath(string path) {
        int n = path.length();
        if(n <= 1) return path;
        path = trim(path);
        vector<string> vec = split(path, '/');
        vector<string> st;
        for(int i = 0 ; i < vec.size(); ++i){
            if(vec[i] == ".") continue;
            else if(vec[i] == ".."){
                if(!st.empty()) st.pop_back();
            }else{
                st.push_back(vec[i]);
            }
        }
        string ans;
        if(st.empty()) return "/";
        for(int i = 0 ;i < st.size(); ++i){
            ans += "/" + st[i];
        }
        return ans;
    }
    
    vector<string> split(const string& path , char deli){
        int n = path.length();
        string tmp;
        vector<string> ans;
        for(int i = 0 ; i < n; ++i){
            if(path[i]==deli) {
                if(!tmp.empty()) {
                    ans.push_back(tmp);
                    tmp = "";
                }
            } else tmp += path[i];
        }
        if(!tmp.empty()) ans.push_back(tmp);
        
        return ans;
    }
    
    string trim(const string& str){
        int n = str.length();
        string tmp;
        int flag = 0;
        for(int i = 0 ; i < n; ++i){
            if(str[i] == '/'){
                if(!flag){
                    tmp += str[i];
                    flag = 1;
                }
            }else{
                flag = 0;
                tmp += str[i];
            }
        }
        return tmp;
    }
};