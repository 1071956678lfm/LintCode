//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
class Solution
{
public:
    int NumberOf1(int n)
    {
        int cnt = 0;
        int mask = 0x7FFFFFFF; //mask code where the first bit is 0
        while (n != 0)
        {
            cnt += n & 1;
            n >>= 1;
            n &= mask;
        }
        return cnt;
    }
};