#include"header.h"

//PS: 和N皇后1没什么区别啊233
class Solution {
public:

    int ans = 0;
    vector<int> cols;// every queen could only be put one column
    int n;

    int totalNQueens(int n) {
        vector<vector<int>> grid(n, vector<int>(n, 0));
        if (n == 0) return ans;
        cols.resize(n, 0);
        this->n = n;
        dfs(grid, 0);
        return ans;
    }

    void dfs(vector<vector<int>> &grids, int row) {
        if (n == row) {
            ans++;
            return ;
        }
        vector<int> ava = getCols(grids, cols, row);
        for (int idx : ava) {
            cols[idx] = 1;
            grids[row][idx] = 1;
            dfs(grids, row + 1);
            grids[row][idx] = 0;
            cols[idx] = 0;
        }
    }

    //Get the valid columns that could be put by one queen
    vector<int> getCols(const vector<vector<int>> &grids,
                        const vector<int> &cols,
                        int row) {
        vector<int> ans;
        for (int i = 0; i < n; ++i) {
            if (!cols[i]) {
                int x = row - 1, y = i - 1;
                bool valid = 1;
                while (x >= 0 && y >= 0) {
                    if (grids[x][y]) {
                        valid = 0;
                        break;
                    }
                    --x;
                    --y;
                }
                x = row - 1;
                y = i + 1;
                while (x >= 0 && y <= n - 1) {
                    if (grids[x][y]) {
                        valid = 0;
                        break;
                    }
                    --x;
                    ++y;
                }

                if (valid) ans.push_back(i);
            }
        }
        return ans;
    }

    vector<string> convert(const vector<vector<int>> path) {
        vector<string> ans;

        for (vector<int> vec : path) {
            string tmp;
            for (int num : vec) {
                tmp += num == 1 ? 'Q' : '.';
            }
            ans.push_back(tmp);
        }
        return ans;
    }
    

};