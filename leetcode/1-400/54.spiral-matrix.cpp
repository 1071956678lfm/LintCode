#include"header.h"

class Solution {
    vector<vector<int>> directions = {
        {0 , 1} , //right
        {1 , 0} , //down
        {0 , -1}, //left
        {-1 ,0}   //up
    };
public:
    vector<int> spiralOrder(vector<vector<int>>& mat) {
        vector<int> ans;
        if(mat.empty() || mat[0].empty()) return ans;
        int m = mat.size() , n = mat[0].size();
        int left = -1 , right = n, 
            top = -1 , btm = m;
        int x =  0, y = 0 , dir = 0;
        while(ans.size() < m * n){
            dir %= 4;
            ans.push_back(mat[x][y]);
            x += directions[dir][0];
            y += directions[dir][1];
            switch(dir){
                case 0://right
                    if(y == right){
                        top++;
                        y --; 
                        x++;
                        dir++;
                    }
                    break;
                case 1://down
                    if(x == btm){
                        right--;
                        x--;
                        y--;
                        dir++;
                    }
                    break;
                case 2://left
                    if(y == left){
                        --btm;
                        ++y;
                        --x;
                        dir++;
                    }
                    break;
                case 3://up
                    if(x == top){
                        ++left;
                        ++x;
                        ++y;
                        dir++;
                    }
                    break;
            }
        }        
        return ans;
    }
};