class Solution {
public:
    int mySqrt(int x) {
        if(x <= 1) return x;
        long long l = 1 , r = x / 2;
        while(l < r){
            int mid = l + (long)r + 1 >> 1;
            if(mid <= x / mid) l = mid;
            else r = mid - 1;
        }
        return l;
    }
};