#include"header.h"


class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        vector<int> ans;
        if(words.empty() || s.empty()) return ans;

        int singleLen = words[0].length() , n = s.length();
        int wordNum = words.size();
        
        for(int i = 0 ; i < n;){
            string T = s.substr(i , n - i);
            if(T.length() < wordNum * singleLen) 
                return ans;
            int len = match(T , words);
            if(len == wordNum * singleLen) ans.push_back(i);
            i++;
        }
        
        return ans;
    }
    
    int match(string s , vector<string>& words){
        int singleLen = words[0].length() , n = s.length();
        int wordNum = words.size();

        vector<int> visited(wordNum , 0);
        int ans = 0;
        
        for(int i = 0 ; i < n ; i += singleLen){
            string target = s.substr(i , singleLen);
            bool found = 0;
            for(int j =  0; j < wordNum ; ++j){
                if(visited[j]) continue;
                if(words[j] == target) {
                    visited[j] = 1;
                    found = 1;
                    ans += singleLen;
                    break;
                }
            }
            if(!found) break;
        }
        return ans;
    }
};