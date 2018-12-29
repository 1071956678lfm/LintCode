package lint;

import org.omg.CORBA.INTERNAL;

public class SolutionQ_181 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public int bitSwapRequired(int a, int b) {
        // write your code here
        int count = 0;
        int result = a ^ b;
        while (result != 0) {
            if (result % 2 != 0)
                count++;
            result = result >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        new SolutionQ_181().bitSwapRequired(31, 14);
    }
}