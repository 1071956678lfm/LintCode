package leet.Answer2019_3;

public class NumberOfDigitOne {
    /**
     * Given an integer n,
     * count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
     * <p>
     * Example:
     * <p>
     * Input: 13
     * Output: 6
     * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
     */

    public int countDigitOne(int n) {
        int ans = 0;
        int tenCount = countTenNum(n);
        int[] total = getTotal(tenCount);
        while (tenCount > 0) {
            int k = (int) (n / Math.pow(10, tenCount));
            if (k > 1)
                ans += Math.pow(10, tenCount);
            ans += k * total[tenCount - 1]; //get rid of pow(10,tenCount)
            n = n - k * (int) Math.pow(10, tenCount);
            tenCount = countTenNum(n);
        }
        return ans + 1;
    }


    private int[] getTotal(int tenCount) {
        int[] total = new int[tenCount];
        total[0] = 1;
        for (int i = 1; i < total.length; ++i) {
            total[i] = (int) (total[i - 1] * 10 + Math.pow(10, i));
        }
        return total;
    }

    private int countTenNum(int n) {
        /*
         *  0 - [0,9]  ( 1 )
         *  1 - [10,99] (10 + total(1)*9) = 18
         *  2 - [100,999] total(2) + ( total(2)*9 + 100 ) =300 = (10* total[i-1] + 10^i)
         *
         *  ...
         * */
        int ans = 0;
        while (n / 10 != 0) {
            ++ans;
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfDigitOne().countDigitOne(100));
    }
}
