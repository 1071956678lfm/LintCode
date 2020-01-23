class Solution {
public:
    int Sum_Solution(int n) {
        // (1 + n) * n / 2
        int ans = n;
        ans && (ans += Sum_Solution(n - 1));
        return ans;
    }
};