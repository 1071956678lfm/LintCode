//
// Created by mac on 2019/9/24.
//

#include <iostream>
#include <vector>

#define ship 'X'
#define dot '.'

using namespace std;

class Solution {
public:
    int countBattleships(vector<vector<char>> &board) {
        return solutionDP(board);
    }

private:
    int solutionDP(vector<vector<char>> &board);

    int solutionOnePass(vector<vector<char>> &board);
};

int Solution::solutionDP(vector<vector<char>> &board) {
    int row = board.size();
    int col = board[0].size();
    if (row * col == 0)
        return 0;
    //construct the dp arr
    vector<vector<int>> dp(row, vector<int>(col, 0));

    if (board[0][0] == dot)
        dp[0][0] = 0;
    else if (board[0][0] == ship)
        dp[0][0] = 1;
    //首先进行边界的分析. 具体为 : 最左侧和最上侧
    for (int i = 1; i < col; ++i) {
        if (board[0][i - 1] == dot && board[0][i] == ship)
            dp[0][i] = dp[0][i - 1] + 1;
        else
            dp[0][i] = dp[0][i - 1];
    }

    for (int i = 1; i < row; ++i) {
        if (board[i - 1][0] == dot && board[i][0] == ship)
            dp[i][0] = dp[i - 1][0] + 1;
        else
            dp[i][0] = dp[i - 1][0];
    }

    for (int i = 1; i < row; ++i) {
        for (int j = 1; j < col; ++j) {
            int basic = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            //add a ship
            if (board[i][j] == ship && board[i - 1][j] == dot && board[i][j - 1] == dot) {
                dp[i][j] = basic + 1;
            } else {
                dp[i][j] = basic;
            }
        }
    }

    return dp[row - 1][col - 1];
}

int Solution::solutionOnePass(vector<vector<char>> &board) {
    int ans = 0;
    int m = board.size();
    int n = board[0].size();
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (board[i][j] == ship &&
                ((i == 0 || board[i - 1][j] == dot)) && (j == 0 || board[i][j - 1] == dot)) {
                ++ans;
            }
        }
    }
    return ans;
}
