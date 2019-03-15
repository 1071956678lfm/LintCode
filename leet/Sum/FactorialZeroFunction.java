package leet.Sum;

import com.sun.org.apache.regexp.internal.RE;

/***/
public class FactorialZeroFunction {
    /**
     * Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3 * ... * x,
     * and by convention, 0! = 1.)
     * <p>
     * For example, f(3) = 0 because 3! = 6 has no zeroes at the end,
     * while f(11) = 2 because 11! = 39916800 has 2 zeroes at the end. Given K,
     * find how many non-negative integers x have the property that f(x) = K.
     * <p>
     * Example 1:
     * Input: K = 0
     * Output: 5
     * Explanation: 0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.
     * <p>
     * Example 2:
     * Input: K = 5
     * Output: 0
     * Explanation: There is no x such that x! ends in K = 5 zeroes.
     * <p>
     * we could compute how many 2 and 5
     * special conditions occurs when we encounter 10. Auto one zero adding to the rear
     * 5! = 5*4*3*2*1 = 120 have one 2
     * <p>
     * 10! = 10*9*8*7*6*5*4*3*2*1
     * <p>
     * 0 1 2 3 4 -> 0
     * 5 6 7 8 9 -> 1
     * .
     * .
     * .
     * 20 21 22 23 24 ->4
     * but
     * 25 26 27 28 29 -> 6 have [5] missed
     */
    public int preimageSizeFZF(int K) {
        return isBreak(K) ? 0 : 5;
    }

    /**
     * 当x=25时，g(x)=2，此时K=5被跳过了。
     * <p>
     * 当x=50时，g(x)=2，此时K=11被跳过了。
     * <p>
     * 当x=75时，g(x)=2，此时K=17被跳过了。
     * <p>
     * 当x=100时，g(x)=2，此时K=23被跳过了。
     * <p>
     * 当x=125时，g(x)=3，此时K=29，30被跳过了。
     * <p>
     * 进一步，我们可以发现如下规律：
     * <p>
     * 5(=1*5), 11(=6*1+5), 17(=6*2+5), 23(=6*3+5), 29(=6*4+5), 30(=6*5), 36(=31+5), 42(=31+6+5), 48(=31+6*2+5)
     * <p>
     * 这些使得x不存在的K，出现都是有规律的，它们减去一个特定的基数base后，都是余5，而余1，2，3，4的，都是返回5。
     * 那么这个基数base，实际是1，6，31，156，...，是由 base = base * 5 + 1，
     * 不断构成的，通过这种不断对基数取余的操作，我们可以最终将K降为小于等于5的数，就可以直接返回结果了
     */
    private boolean isBreak(int num) {
        int singleBase = 1;
        int totalBase = 1;

        while (totalBase < num) {
            singleBase *= 5;
            totalBase += singleBase;
        }
        while (totalBase > 1) {
            if (num % totalBase == totalBase - 1)
                return true;
            num -= num / totalBase;
            totalBase -= singleBase;
            singleBase /= 5;
        }
        return false;
    }

    /**
     * @param num:The target number , we wil compute the number of the zero of num!
     * @return: The zero number
     */
    private int countFactorialZero(int num) {
        if (num == 0)
            return 1;
        int count_5 = 0;
        for (int i = 5; i <= num; i++) {
            count_5 += getNumOfRadix(i, 5);
        }
        return count_5;
    }

    /**
     * @param num   :The target number value. radix should be no less than 2
     * @param radix :The base radix
     * @return value is between the [base^(x),base^(x+1)]
     */
    private int getNumOfRadix(int num, int radix) {
        assert radix >= 2;
        if (num < radix)
            return 0;
        int count = 0;
        while (num >= radix) {
            if (num % radix == 0) {
                ++count;
                num /= radix;
            } else
                return count;

        }
        return count;
    }

    /**
     * 如果x 在[5^base , 5^(base+1)] , 那么额外需要添加的5的幂次个数为1+2+....+(base-1) = base*(base-1)/2;
     */
    private int additionalSum(int base) {
        return base * (base - 1) / 2;
    }

    public static void main(String[] args) {
        new FactorialZeroFunction().isBreak(25);
//        new FactorialZeroFunction().countFactorialZero(10);
    }
}
