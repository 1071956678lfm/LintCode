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
        if (n <= 0)
            return 0;
        int tenCount = countTenNum(n);
        if (tenCount == 0)
            return 1;
        int[] total = getTotal(tenCount);
        while (n > 0) {
            int k = (int) (n / Math.pow(10, tenCount)); // base k * 10^tenCount + C = n
            if (k > 1) {
                ans += Math.pow(10, tenCount); //add 1xxxx - 199999..
            } else { // n = 1xxxx
                ans += n - (int) Math.pow(10, tenCount) + 1;
            }
            if (tenCount == 0)
                break;
            ans += k * total[tenCount - 1]; //get rid of pow(10,tenCount)
            n = n - k * (int) Math.pow(10, tenCount);
            tenCount = countTenNum(n);
        }
        return ans;
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
        int ans = 0;
        while (n / 10 != 0) {
            ++ans;
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfDigitOne().countDigitOne(1));
    }
}
