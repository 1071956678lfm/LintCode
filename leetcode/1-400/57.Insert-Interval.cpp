#include"header.h"

class SolutionA {
public:
    vector<vector<int>> merge(vector<vector<int>>& mat) {
        int n = mat.size();
        vector<vector<int>> ans;
        if(n <= 1) return mat;
        sort(mat.begin() , mat.end() , [](vector<int>& i1 , vector<int>& i2)->bool{
           return i1[0] < i2[0]; 
        });
        
        for(int i = 0; i < n;){
            int j = i + 1;
            int l = mat[i][0] , r = mat[i][1];
            for(; j < n && r >= mat[j][0] ; ++j){
                r = max(r,  mat[j][1]);
            }
            ans.push_back({l , r});
            i = j;
        }
        return ans;
    }
};

class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& mat, vector<int>& interval) {
        int n = mat.size();
        mat.push_back(interval);
        return SolutionA().merge(mat);
    }
};