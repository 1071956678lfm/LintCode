#include"header.h"

//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
//例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
class Solution {
private:
    vector<string> ans;
    vector<char> path;
    vector<int> visited;

public:
    vector<string> Permutation(string str) {
        int n = str.size();
        if(n ==0) return ans;
        path.resize(n, 0);
        visited.resize(n, 0);
        dfs(str, 0, 0);
        sort(ans.begin() , ans.end());
        return ans;
    }

    void dfs(const string &str, int idx, int start) {
        int n = str.length();
        if (idx == n) {
            string s = "";
            for (auto ch : path) s += ch;
            ans.push_back(s);
            return;
        }
        for (int i = start; i < n; ++i) {
            if (!visited[i]) {
                visited[i] = 1;
                path[i] = str[idx];
                dfs(str, idx + 1, idx + 1 < n &&
                                  str[idx] == str[idx + 1] ? i + 1 : 0);
                visited[i] = 0;
            }
        }
    }
};