#include"header.h"

class Solution {
public:
    void rotate(vector<vector<int>>& mat) {
        if(mat.empty() || mat[0].empty()) return;
        int m = mat.size() , n = mat[0].size();
    
        reverse(mat.begin() , mat.end());
        for(int i = 0 ; i < m ; ++i){
            for(int j = i + 1; j < n ; ++j){
                swap(mat[i][j] , mat[j][i]);
            }
        }
    }
}