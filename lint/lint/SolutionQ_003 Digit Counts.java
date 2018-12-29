package lint;

public class SolutionQ_003 {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int result = 0;
        if (n < 0)
            return 0;
        for (int num = 0; num <= n; num++) {
            char[] numStr = Integer.toString(num).toCharArray();
            for (char ch : numStr) {
                int val=ch-'0';
                if (val==k)
                    result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new SolutionQ_003().digitCounts(1,12);
    }
}
