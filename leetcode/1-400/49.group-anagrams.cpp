#include"header.h"

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int n = strs.size();
        map<string , vector<string>> hash;
        vector<vector<string>> ans;
        if(n == 0) return ans;
        for(string s : strs){
            string tmp = s;
            sort(s.begin() , s.end());
            hash[s].push_back(tmp);
        }
        
        for(pair<string , vector<string>> p : hash)
            ans.push_back(p.second);
        
        return ans;
    }
};