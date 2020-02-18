#include"header.h"

typedef vector<vector<char>> chs;

class Solution {
public:
    const vector<vector<int>> directions = {
        {0, 1},{0,-1},{1,0},{-1,0}  
    };
    
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size() , n = board[0].size();
        int ans = 0;
        for(int i = 0; i <m ; ++i){
            for(int j = 0 ; j < n ;++j){
                if(word[0] == board[i][j]){
                    ans |= dfs(board, word,0, i ,j);
                    if(ans) return true;
                }
            }
        }
        return false;
    };
    
    bool dfs(chs & board , string word, int idx, int x , int y){
        if(word.length() == idx) 
            return true;
        int n1 = board.size() , n2 = board[0].size();
        if(x < 0 || x >= n1 || y <0 || y >= n2 || 
           board[x][y] != word[idx]) 
            return false;
        
        board[x][y] = '.';
        int ans = 0;
        for(auto dir : directions){
            ans |= dfs(board, word, idx + 1, x + dir[0] , y + dir[1]);
            if(ans) break;
        }
        board[x][y] = word[idx];
        return ans;
             
    }
};