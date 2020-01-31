#include "header.h"

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:

//(you may want to display this pattern in a fixed font for better legibility)
class Solution
{
public:
    string convert(string s, int numRows)
    {
        int n = s.size();
        if (n <= 1 || numRows == 1)
            return s;
        vector<vector<char>> grid(numRows);
        int cnt = 0, down = 1;

        for (int i = 0; i < n; ++i)
        {
            grid[cnt].push_back(s[i]);

            if (down)
            {
                cnt++;
                if (cnt == numRows)
                {
                    cnt -= 2;
                    down = 0;
                }
            }
            else
            {
                cnt--;
                if (cnt == -1)
                {
                    cnt += 2;
                    down = 1;
                }
            }
        }
        string ans;
        for (auto vec : grid)
            for (auto ch : vec)
                ans += ch;
        return ans;
    }
};