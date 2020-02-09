#include"header.h"

class Solution {
public:
    vector<vector<int>> directions = {
        {0 ,1},//right
        {1 , 0},//down
        {0 , -1},//left
        {-1 , 0}//up
    };
    
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> ans(n , vector<int>(n));
        if(n == 0) return ans;
        int cnt = 0 , limit = n * n;
        int left = - 1 , right = n , 
            top = -1 , btm = n;
        int x = 0 , y = 0 , dir = 0;
        while(cnt < limit){
            dir %= 4;
            ans[x][y] = cnt + 1; 
            ++cnt;
            x += directions[dir][0];
            y += directions[dir][1];
            switch(dir){
                case 0://right (1 , -1)
                    if(y == right){
                        ++x;
                        --y;
                        ++top;
                        ++dir;
                    }
                    break;
                case 1://down (-1 , -1)
                    if(x == btm){
                        --x;
                        --y;
                        --right;
                        ++dir;
                    }
                    break;
                case 2:
                    if(y == left){
                        --x;
                        ++y;
                        --btm;
                        ++dir;
                    }
                    break;
                case 3:
                    if(x == top){
                        ++x;
                        ++y;
                        ++left;
                        ++dir;
                    }
                    break;
            }
        }
        return ans;
    };
};