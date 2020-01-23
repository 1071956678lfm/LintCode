#include"header.h"

//“student. a am I” -> "I am a student."
//使用栈
class Solution {
public:
    string ReverseSentence(string str) {
        if(str.empty()) return "";
        stack<string> st;

        int n = str.length();
        string path = "";
        for (int i = 0; i < n; ++i) {
            if (str[i] != ' ')
                path += str[i];
            else if(!path.empty()){
                st.push(path);
                path = "";
            }
        }
        if (!path.empty()) st.push(path);
        string ans = "";
        while (!st.empty()) {
            ans += st.top();
            st.pop();
            if (!st.empty()) ans += ' ';
        }
        return ans;
    }
};