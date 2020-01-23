class Solution {
public:
    int Add(int num1, int num2)
    {
         int ans = 0 , sum = 0;
        do{
            ans = num1 ^ num2;
            sum = (num1 & num2) << 1;
            num1 = ans;
            num2 = sum;
        }while(sum);
        return ans;
    }
};