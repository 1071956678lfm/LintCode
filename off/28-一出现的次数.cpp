class Solution {
public:
    int NumberOf1Between1AndN_Solution(int n)
    {
       int ans = 0;
       for(int i = n ; i >= 1; --i) 
           ans += getNum(i);
        return ans;
    }
    int getNum(int n ){
        int cnt = 0 ;
        while(n){
            if(n % 10 == 1) ++cnt;
            n /= 10;
        }
        return cnt;
    }      
};