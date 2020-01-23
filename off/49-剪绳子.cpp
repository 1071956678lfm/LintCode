#include"header.h"

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
*/
class Solution {
public:
    int cutRope(int n) {
        int l = 2 , r = n;
        
        int ans = 0;
        for(int i = l ; i <= r ;++i){
            ans = max(ans , splitVal(n , i));
        }
        return ans;
    }
    
    int splitVal(int n , int k){
        if(k == n) return 1;
        vector<int> vec(k , 0);
        
        int idx = 0;
        while(n){
            vec[idx % k]++;
            --n; ++idx;
        }
        int ans = 1;
        for(auto num : vec) ans *= num;
        return ans;
    }
};