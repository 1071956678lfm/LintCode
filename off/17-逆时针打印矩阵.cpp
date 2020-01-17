#include"header.h"

//FA实现
class Solution {
public:
    const enum {
        R = 0, D, L, U,
    };

    vector<int> printMatrix(vector<vector<int> > mat) {
        int m = mat.size(), n = mat[0].size(), total = m * n;
        vector<int> ans;
        int i = 0, j = 0, dirIdx = 0,
                top = 0, left = 0, right = n - 1, bottom = m - 1;
        while (true) {
            if (ans.size() == total) break;

            switch (dirIdx % 4) {
                case R:
                    ans.push_back(mat[i][j]);
                    ++j;
                    if (j > right) {
                        --j;
                        ++top;
                        ++i;
                        ++dirIdx;
                    }
                    break;
                case D:
                    ans.push_back(mat[i][j]);
                    ++i;
                    if (i > bottom) {
                        --i;
                        --right;
                        --j;
                        ++dirIdx;
                    }
                    break;
                case L://to left
                    ans.push_back(mat[i][j]);
                    --j;
                    if (j < left) {
                        ++j;
                        --bottom;
                        --i;
                        ++dirIdx;
                    }
                    break;
                case U:// to up
                    ans.push_back(mat[i][j]);
                    --i;
                    if (i < top) {
                        ++i;
                        ++left;
                        ++j;
                        ++dirIdx;
                    }
                    break;
            }
        }
        return ans;
    }
};