#include"header.h"

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        if(board.empty() || board[0].empty()) return 1;
        int m = board.size() , n = board[0].size();
        
        unordered_map<int,int> hash;
        for(int i = 0; i < m ; ++i){
            for(int j = 0 ; j < n ; ++j){
                char val = board[i][j];
                if(val != '.'){
                    if(hash[val] > 0) return 0;
                    hash[val] = 1;
                }
            }
            hash.clear();
        }
        
        for(int j = 0; j < n ; ++j){
            for(int i = 0 ; i < m ; ++i){
                char val = board[i][j];
                if(val != '.'){
                    if(hash[val] > 0) return 0;
                    hash[val] = 1;
                }
            }
            hash.clear();
        }
        
        for(int cnt = 0; cnt < 9 ; ++cnt){
            int x = (cnt / 3) * 3 , y = (cnt % 3) * 3;
            for(int i = 0 ; i < 3;  ++i){
                for(int j = 0 ; j < 3; ++j){
                    char val = board[x + i][y + j];
                    if(val == '.') continue;
                    if(hash[val] > 0) return 0;
                    hash[val] = 1;
                }
            }
            hash.clear();
        }
        
        
        return 1;
    }
};