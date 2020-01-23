#include"header.h"

//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格
//，但是不能进入行坐标和列坐标的数位之和大于k的格子。 
//例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
//但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
//注意：起始位置为 0 , 0
class Solution {
    const vector<vector<int>> directions = {
            {0,  1},
            {0,  -1},
            {1,  0},
            {-1, 0}
    };
public:
    int movingCount(int k, int m, int n) {
        queue<pair<int, int>> queue;
        vector<vector<int>> visited(m , vector<int>(n , 0));
        int r = 0, c = 0, ans = 0;
        queue.push({r, c});
        while (!queue.empty()) {
            auto front = queue.front();
            int x = front.first, y = front.second;
            queue.pop();
            if(isValid(x , y , m , n) && !visited[x][y]){
                visited[x][y] = 1;
                if(getVal(x, y) <= k){
                    ++ans;
                for (auto dir : directions)
                     queue.push({x + dir[0], y + dir[1]});
                }
            }
        }
        return ans;
    }

    int isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    int getVal(int x, int y) {
        int ans = 0;
        while (x) {
            ans += x % 10;
            x /= 10;
        }
        while (y) {
            ans += y % 10;
            y /= 10;
        }
        return ans;
    }
};