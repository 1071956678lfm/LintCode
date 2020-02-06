#include"header.h"

class Solution {
public:
    void solveSudoku(vector<vector<char>> &board) {
        int m = board.size(), n = board[0].size();

        int x = 0, y = 0;
        pair<int, int> p = findNext(board, 0, 0);
        if (p.first == -1) {
            return;
        }
        x = p.first;
        y = p.second;

        dfs(board, x, y);

    }

    //return false if the search is not success
    static bool dfs(vector<vector<char>> &board,
             int x, int y) {
        int m = board.size(), n = board[0].size();
        pair<int, int> p(x, y);
        if (board[x][y] != '.') {
            p = findNext(board, x, y);
            if (p.first == -1) return 1;
            //update
            x = p.first;
            y = p.second;
        }
        if (x == m - 1 && y == n - 1 && board[x][y] != '.')
            return true;
        vector<char> ava = avalVals(board, x, y);
        //dfs search
        for (char ch : ava) {

            board[x][y] = ch;
            bool ans = dfs(board, x, y);
            if (ans) return true;
            else board[x][y] = '.';
        }

        return false;
    }


    static pair<int, int> findNext(const vector<vector<char>> &board,
                                   int x, int y) {
        int m = board.size(), n = board[0].size();
        bool found = false;
        for (int i = 0; !found && i < m; ++i) {
            for (int j = 0; !found && j < n; ++j) {
                if (board[i][j] == '.') {
                    x = i;
                    y = j;
                    found = true;
                }
            }
        }
        if (!found) return pair<int, int>(-1, -1);
        return pair<int, int>(x, y);

    }

    static vector<char> avalVals(const vector<vector<char>> &board,
                          int x, int y) {
        int m = board.size(), n = board[0].size();
        vector<int> tmp(10, 1);

        for (int i = 0; i < m; ++i) {
            if (board[i][y] == '.') continue;
            tmp[board[i][y] - '0']--;
        }

        for (int j = 0; j < n; ++j) {
            if (board[x][j] == '.') continue;
            tmp[board[x][j] - '0']--;
        }

        int lx = (x / 3) * 3, ly = (y / 3) * 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (lx + i == x && ly + y == y) continue;
                char val = board[lx + i][ly + j];
                if (val != '.') {
                    tmp[val - '0']--;
                }
            }
        }

        vector<char> ans;
        for (int i = 1; i < tmp.size(); ++i) {
            if (tmp[i] > 0) {
                ans.push_back(i + '0');
            }
        }
        return ans;
    }

};