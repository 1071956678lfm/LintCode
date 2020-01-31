#include"header.h"

class Solution {
public:
    bool isValid(string s) {
        map<char,char> hash;
        hash['('] = ')';
        hash['{'] = '}';
        hash['['] = ']';
        
        stack<char> st;
        if(s.empty()) return 1;
        
        for(int i = 0 ; i < s.length(); ++i){
            switch(s[i]){
                case '(':
                case '[':
                case '{':
                    st.push(s[i]);
                    break;
                case ']':
                case ')':
                case '}':
                    if(st.empty() || hash[st.top()] != s[i]) return 0;
                    st.pop();
                    break;
                default:
                    return 0;
                    break;
            }
        }
        return st.empty();
    }
};