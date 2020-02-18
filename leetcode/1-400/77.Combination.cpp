#include"header.h"

class Solution {
public:
    vector<vector<int>> ans;
    vector<int> path;
    vector<int> visited;
    int n;
    
    vector<vector<int>> combine(int n, int k) {
        this->n = n ;
        if(n * k == 0) return ans;
        visited.resize(n + 1 , 0);
        dfs(1 , k);
        return ans;
    }
    
    void dfs(int start , int size){
        if(size == 0) {
            ans.push_back(path);
            return;
        }
        
        for(int i = start ; i <= n ; ++i){
            if(!visited[i]) {
                visited[i] = 1;
                path.push_back(i);
                dfs(i , size - 1);
                path.pop_back();
                visited[i] = 0;
            }            
        }
    }
};