#include"header.h"

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& mat, int target) {
        if(mat.empty() || mat[0].empty()) return 0;
        int m = mat.size() , n = mat[0].size();
        int l = 0 , r = m * n - 1;
        
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(mat[mid / n][mid % n] <= target) l = mid;
            else r = mid - 1;
        }
        return mat[r / n][r % n] == target;
    }
};