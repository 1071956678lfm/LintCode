#include"header.h"

//把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 
//习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
class Solution {
public:
    int GetUglyNumber_Solution(int n) {
        int p2 = 0 ,
            p3 = 0 ,
            p5 = 0;
        vector<int> ans(n + 1, 0);
        ans[0] = 1;
        for(int i = 1; i <= n ; ++i){
            ans[i] = min3(ans[p2] * 2, ans[p3] * 3, ans[p5] * 5);
            if(ans[i] == ans[p2] * 2) ++p2;
            if(ans[i] == ans[p3] * 3) ++p3;
            if(ans[i] == ans[p5] * 5) ++p5;
        }
        return ans[n - 1];
    }
    
    int min3(int a, int b , int c){
        return min(a , min(b , c));
    }
};