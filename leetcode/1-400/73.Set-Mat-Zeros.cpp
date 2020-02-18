#include"header.h"

class Solution {
public:
    void setZeroes(vector<vector<int>>& mat) {
        if(mat.empty() || mat[0].empty()) return ;
        int m = mat.size() , n = mat[0].size();
        vector<int> cols , rows;
        
        for(int i = 0; i < m ; ++i)
            for(int j = 0 ; j < n; ++j){
                if(mat[i][j] == 0) {
                    cols.push_back(j);
                    rows.push_back(i);
                }
            }
        //rows
        for(int r : rows){
            for(int j = 0 ; j < n ; ++j) mat[r][j] = 0;
        }
        for(int c : cols){
            for(int i = 0; i < m; ++i) mat[i][c] = 0;
         }
        
    }
};