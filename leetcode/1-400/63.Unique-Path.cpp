#include"header.h"

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& mat) {
        if(mat.empty() || mat[0].empty()) return 0;
        int m = mat.size() , n = mat[0].size();
        vector<vector<long long>> dp(m , vector<long long>(n));
        dp[0][0] = mat[0][0] == 0;
        
        for(int i = 1; i < m ; ++i) dp[i][0] = dp[i - 1][0] & (mat[i][0] == 0);
        for(int i = 1; i < n ; ++i) dp[0][i] = dp[0][i - 1] & (mat[0][i] == 0);
        
        for(int i = 1; i < m ; ++i){
            for(int j = 1; j < n ; ++j){
                dp[i][j] = (mat[i][j] == 1) ? 0 : 
                dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
};