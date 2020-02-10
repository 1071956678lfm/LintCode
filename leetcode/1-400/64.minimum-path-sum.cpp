#include"header.h"

class Solution {
public:
    int minPathSum(vector<vector<int>>& mat) {
        if(mat.empty() || mat[0].empty()) return 0;
        int m = mat.size() , n = mat[0].size();
        vector<vector<int>> dp(m , vector<int>(n));
        
        dp[0][0] = mat[0][0];
        for(int i = 1 ; i < m ; ++i) dp[i][0] = dp[i - 1][0] + mat[i][0];
        for(int j = 1 ; j < n; ++j) dp[0][j] = dp[0][j - 1] + mat[0][j];
        
        for(int i = 1; i < m ;++i){
            for(int j = 1; j < n; ++j){
                dp[i][j] = mat[i][j] + min(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
        return dp.back().back();
    }
};